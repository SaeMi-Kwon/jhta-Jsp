package test.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("content", "/WEB-INF/views/home.jsp");
		//다이렉트는 안됨(외부에서 타고오는방식라서 사용못함)
		req.getRequestDispatcher("/WEB-INF/views/layout.jsp").forward(req, resp); 
	}
}
