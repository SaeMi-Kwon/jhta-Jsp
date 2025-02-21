package test.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.dao.BoardDao;
import test.dto.Board;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String field=req.getParameter("field");
		String keyword=req.getParameter("keyword");
		
		//일시적인경우 HashMap를 사용 (여러곳에서도 사용할경우 dto 따로 만들어서 사용하는법도 있음)
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("field", field);
		map.put("keyword", keyword);
		
		
		BoardDao dao=new BoardDao();
		List<Board> list=dao.selectList(map);
		
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/board/list.jsp").forward(req, resp);
		
	}
}
