package test.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.PageContext;
import test.dao.BoardDao;

@WebServlet("/board/delete")
public class DeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("num"));
		
		
		BoardDao dao=BoardDao.getInstance();
		
		dao.delete(num);
		
		System.out.println("삭제:" + num);
		
		resp.sendRedirect(req.getContextPath() + "/board/list.jsp");
		
	}
}
