package test.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.UUID;
import java.util.function.Consumer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import test.dao.BItemDao;
import test.dao.ItemFilesDao;
import test.dto.BItemDTO;
import test.dto.ItemFilesDTO;

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 10,  //10MB
		maxRequestSize = 1024 * 1024 * 50 //50MB
)
@WebServlet("/item/insert")
public class ItemInsertController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/item/insert.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path=req.getServletContext().getRealPath("/upload");
		System.out.println("path==>" + path);
		
		String itemname=req.getParameter("itemname");
		String descrip=req.getParameter("descrip");
		int price=Integer.parseInt(req.getParameter("price"));
		
		try {	
			//BItem테이블에 저장해보세요(BItemDao)
			BItemDTO bitemdto=new BItemDTO(0,itemname,descrip,price);
			BItemDao bitemdao=BItemDao.getInstance();
			int inum=bitemdao.insert(bitemdto);
			
			
			//Part part=req.getPart("file1"); //파일이 하나만 첨부된 경우
			Collection<Part> parts=req.getParts();
			
			//풀어서 작성
//			Consumer<Part> cs=new Consumer<Part>() {
//				@Override
//				public void accept(Part part) {
//					if(part.getName().equals("file1")) {
//						String orgfilename=part.getSubmittedFileName();
//						String savefilename=UUID.randomUUID() + "_" + orgfilename; 
//						long filesize=part.getSize();  
//						
//						try {
//							InputStream is=part.getInputStream();
//							FileOutputStream fos=new FileOutputStream(path + File.separator +orgfilename);
//							is.transferTo(fos);  //파일복사
//							fos.close();
//							is.close();
//							System.out.println("업로드완료!");
//						} catch (IOException ie) {
//							System.out.println(ie.getMessage());
//						}
//					}
//				}
//			};
			//parts.forEach(cs);
			
			parts.forEach((part)->{
				if(part.getName().equals("file1")) { //전송된 파라미터가 파일인 경우
					String orgfilename=part.getSubmittedFileName(); //전송된 파일명
					String savefilename=UUID.randomUUID() + "_" + orgfilename; //저장할 파일명
					long filesize=part.getSize();  //파일크기
					
					try {
						//전송된 파일을 읽어오기위한 스트림
						InputStream is=part.getInputStream();
						//파일로 저장할 스트림
						FileOutputStream fos=new FileOutputStream(path + File.separator +orgfilename);
						is.transferTo(fos);  //파일복사
						fos.close();
						is.close();
						System.out.println("업로드완료!");
					}catch(IOException ie) {
						System.out.println(ie.getMessage());
					}
				
					//파일정보 db에 저장
					ItemFilesDao itemFilesDao=ItemFilesDao.getInstance();
					itemFilesDao.insert(new ItemFilesDTO(0,inum,orgfilename,savefilename,filesize));
				
				}
			});
			req.setAttribute("code", "success");
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
			req.setAttribute("code", "fail");
		
		}
		req.getRequestDispatcher("/item/result.jsp").forward(req, resp);
	}
}
