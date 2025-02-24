package test.controller;

import java.io.IOException;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import test.dao.BoardDao;

@WebServlet("/board/searchList")
public class searchListController extends HttpServlet{
	
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String writer=req.getParameter("writer");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		String keyword=req.getParameter("keyword");
		
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("writer", writer);
		map.put("title", title);
		map.put("content", content);
		map.put("keyword", keyword);
		
		BoardDao dao=new BoardDao();
		req.setAttribute("list", dao.searchList(map));
		req.getRequestDispatcher("/board/searchList.jsp").forward(req, resp);
		
	}

}
