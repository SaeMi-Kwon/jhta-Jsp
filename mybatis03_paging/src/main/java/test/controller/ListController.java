
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
import test.util.PageUtil;

@WebServlet("/board/list")
public class ListController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageNum=1;
		
		String page=req.getParameter("pageNum");
		String field=req.getParameter("field");
		String keyword=req.getParameter("keyword");
		
		if(page!=null) {
			pageNum=Integer.parseInt(page);
		}
		
		
		BoardDao dao=new BoardDao();
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("field", field);
		map.put("keyword", keyword);
		
		
		int totalRowCount= dao.getCount(map);  //전체글의 갯수 구하기
		PageUtil pu=new PageUtil(pageNum, totalRowCount , 5);
		int startRow=pu.getStartRow();
		int endRow=pu.getEndRow();
		
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<Board> list=dao.list(map);
		
		
		req.setAttribute("list", list);
		req.setAttribute("pageCount", pu.getPageCount());
		req.setAttribute("startPage", pu.getStartPage());
		req.setAttribute("endPage", pu.getEndPage());
		req.setAttribute("pageNum", pageNum);

		req.setAttribute("field", field);
		req.setAttribute("keyword", keyword);

		req.getRequestDispatcher("/board/list.jsp").forward(req, resp);
		
	}
}
