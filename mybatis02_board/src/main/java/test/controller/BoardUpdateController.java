package test.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.dao.BoardDao;
import test.dto.Board;

@WebServlet("/board/update")
public class BoardUpdateController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("num"));

		BoardDao dao=new BoardDao();
		Board dto=dao.getInfo(num);
		
		req.setAttribute("dto",dto);
		
		req.getRequestDispatcher("/board/update.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("num"));
		String writer=req.getParameter("writer");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		
		Board dto=new Board(num,writer,title,content,null);
		BoardDao dao=new BoardDao();
		dao.update(dto);
		
		resp.sendRedirect(req.getContextPath()+"/board/list");
	}
}
