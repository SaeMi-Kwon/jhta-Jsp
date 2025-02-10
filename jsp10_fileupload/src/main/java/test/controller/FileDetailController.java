package test.controller;

import java.io.IOException;
import java.io.InputStream;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.dao.FileInfoDao;
import test.dto.FileInfoDTO;

@WebServlet("/file/detail")
public class FileDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("filenum"));
		
		FileInfoDao dao=new FileInfoDao();
		FileInfoDTO detail=dao.detail(num);
		
		//글내용 얻어오기
		String content=detail.getContent();   
				
		//줄바꿈글자(\r\n)를 br태그로 변경하기
		content = content.replace("\r\n", "<br>");  
				
		//바뀐 문자열을 content에 저장
		detail.setContent(content);
		
		req.setAttribute("detail", detail);

		req.getRequestDispatcher("/file/detail.jsp").forward(req, resp);
		
	}
}
