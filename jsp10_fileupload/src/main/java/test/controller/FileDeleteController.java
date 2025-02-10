package test.controller;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.dao.FileInfoDao;
import test.dto.FileInfoDTO;

@WebServlet("/file/delete")
public class FileDeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("filenum"));
	
		FileInfoDao dao = new FileInfoDao();
		
		//savefilename 값을 얻어옴
		FileInfoDTO dto =dao.detail(num);
		String save=dto.getSavefilename();
		//String save=dao.detail(num).getSavefilename();
		
		System.out.println("저장된 파일명" +save);
		
		//경로얻어오기
		ServletContext application=req.getServletContext();
		String path=application.getRealPath("/upload");
		//String path=req.getServletContext().getRealPath("/upload");
		
		//1.파일에서 삭제
		File f=new File(path + File.separator + save);
		f.delete();
		
		//2.db삭제
		dao.delete(num);
		
		System.out.println("저장된 파일명 "+save);
		
		resp.sendRedirect(req.getContextPath() + "/file/list");
	}
}
