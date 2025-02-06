package test.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.dao.BoardDao;
import test.dto.Board;

@WebServlet("/board/insert")
public class InsertController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/board/insertForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String writer = req.getParameter("writer");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
			
		Board dto=new Board(-1,writer,title,content,null);
		BoardDao dao=new BoardDao();
		
		int n = dao.insert(dto);
		
		if(n>0) {
			req.setAttribute("result", "1");
		}else {
			req.setAttribute("result", "0");
		}
		
		req.getRequestDispatcher("/board/result.jsp").forward(req, resp);
		
	}
}
