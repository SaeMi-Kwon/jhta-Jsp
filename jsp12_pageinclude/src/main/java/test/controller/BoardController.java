package test.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<String> list =new ArrayList<>();
		
		list.add("게시글1");
		list.add("게시글2");
		list.add("게시글3");
		
		req.setAttribute("list",list);
		
		req.setAttribute("content", "/WEB-INF/views/board.jsp");
		
		req.getRequestDispatcher("/WEB-INF/views/layout.jsp").forward(req, resp);
	}

}
