package test.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.dao.MovieDao;
import test.dto.MovieDTO;

@WebServlet("/main")
public class MainController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MovieDao dao=new MovieDao();
		ArrayList<MovieDTO> list=dao.mList();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/main.jsp").forward(req, resp);
		
	}
	
}
