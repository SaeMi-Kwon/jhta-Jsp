package test.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import test.dao.FileInfoDao;
import test.dto.FileInfoDTO;

@MultipartConfig(
		fileSizeThreshold= 1024 * 1024 * 2,
		maxFileSize= 1024 * 1024 * 10,
		maxRequestSize= 1024 * 1024 * 50
)
@WebServlet("/file/update")
public class FileUpdateController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("filenum"));
		FileInfoDao dao=new FileInfoDao();
		FileInfoDTO dto=dao.detail(num);	
		
		req.setAttribute("dto", dto);
		
		req.getRequestDispatcher("/file/updateForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("filenum"));
		String writer=req.getParameter("writer");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		Part part=req.getPart("fileUpdate");
		long size=part.getSize();  //수정할 파일이 전송될때 크기 구하기
		
		
		FileInfoDao dao= new FileInfoDao();
		FileInfoDTO f=dao.detail(num);
		
		
		//db에 저장되어있는 기존에 전송되었던 파일정보 얻어오기
		long filesize=f.getFilesize(); 
		String orgfilename=f.getOrgfilename();
		String savefilename=f.getSavefilename();
		

		if(size!=0){  //수정할 파일이 전송된 경우
			String path=req.getServletContext().getRealPath("/upload");
			
			//1.기존 파일 삭제하기
			File delfile = new File(path + File.separator + savefilename);
			delfile.delete();
			
			//2.새롭게 전송된 파일 업로드하기
			orgfilename=part.getSubmittedFileName();
			savefilename=UUID.randomUUID()+"_"+orgfilename;
			filesize=part.getSize();

			FileOutputStream fos=new FileOutputStream(path + File.separator + savefilename);
			InputStream is=part.getInputStream();
			is.transferTo(fos);
			
			is.close();
			fos.close();

		}else {  //수정할 파일이 전송되지 않는 경우 - 기존 파일정보 유지
			//구현안해도 된다.
		}
		
		//db수정하기
		FileInfoDTO dto=new FileInfoDTO(num,writer,title,content,orgfilename,savefilename,filesize);
		dao.update(dto);
		
		
		resp.sendRedirect(req.getContextPath()+"/file/detail?filenum=" + num);
		
	}
}
