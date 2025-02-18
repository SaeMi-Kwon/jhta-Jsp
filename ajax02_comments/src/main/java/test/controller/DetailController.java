package test.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.dao.MovieDao;
import test.dto.MovieDTO;

@WebServlet("/detail")
public class DetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mnum=Integer.parseInt(req.getParameter("mnum"));
		
		MovieDao dao=new MovieDao();
		MovieDTO dto=dao.select(mnum);
		
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/detail.jsp").forward(req, resp);
	}
}
