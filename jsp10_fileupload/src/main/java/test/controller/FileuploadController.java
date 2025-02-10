package test.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import test.dao.FileInfoDao;
import test.dto.FileInfoDTO;


//임시저장소 설정
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 2,  //2mb
		maxFileSize = 1024 * 1024 * 10,  //최대업로드파일크기 10mb로 제한
		maxRequestSize = 1024 * 1024 * 50  //최대요청크기 50mb로 제한(다중파일첨부)
)
//@MultipartConfig  //"multipart/form-data" 형식의 데이터를 처리가능하도록 하는 어노테이션
@WebServlet("/file/upload")
public class FileuploadController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/file/insert.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String writer=req.getParameter("writer");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		
		
		//------------------------1.파일업로드하기 ------------------------//
		//서블릿컨텍스트(jsp -> application) 객체 얻어오기
		ServletContext application=req.getServletContext();
		String path=application.getRealPath("/upload");
		System.out.println("path:" + path);
		
		try {
			//전송된 파일정보 읽어와 서버(upload폴더)에 업로드(파일복사)하기
			Part part=req.getPart("file1");
			
			//전송된 파일명 얻어오기
			String orgfilename=part.getSubmittedFileName(); //전송된 파일명
			
			//저장할 파일명 구하기(중복되지 않는 파일명으로 만들기)
			String savefilename=UUID.randomUUID() + "_" + orgfilename;
			
			//전송된 파일을 서버에 복사(출력)하기 위한 스트림 객체 (서버에 저장)
			FileOutputStream fos=new FileOutputStream(path + File.separator + savefilename); 
			
			//전송된 파일을 읽어오기 위한 스트림 객체 (사용자가 전송한파일 읽어오기)
			InputStream is=part.getInputStream();
			
			//##파일복사
	//		while(true) {
	//			int n=is.read();
	//			fos.write(n);
	//			if(n==-1) break;
	//		}
			
			//파일복사 하기
			is.transferTo(fos);  
			
			is.close();
			fos.close();
			
			//전송된 파일크기 구하기(얻어오기)
			long filesize=part.getSize();
			
			
		//---------------  2.업로드된 파일정보를 db에 저장하기 --------------//
			FileInfoDTO dto=
					new FileInfoDTO(0,writer,title,content,orgfilename,savefilename,filesize);
			
			FileInfoDao dao = new FileInfoDao();
			dao.insert(dto);
			
			req.setAttribute("orgfilename", orgfilename);
			req.setAttribute("savefilename", savefilename);
			req.setAttribute("filesize", filesize);
			req.setAttribute("result", "success");
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
			req.setAttribute("result", "fail");
		}
		
		//------------------------------------------------------------//
		
		req.getRequestDispatcher("/file/result.jsp").forward(req, resp);
		
	}
	
}
