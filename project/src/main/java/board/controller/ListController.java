package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.BoardDao;
import dto.BoardDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board/list")
public class ListController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page=req.getParameter("pageNum");
		
		int pageNum=1;  
		
		if(page!=null) {
			pageNum=Integer.parseInt(page);
		}
		
		int startRow=(pageNum-1)*10+1;
		int endRow=startRow+9;
		
		BoardDao dao=new BoardDao();
		ArrayList<BoardDto> list = dao.list(startRow,endRow);
		
		int pageCount=(int)Math.ceil(dao.getCount()/10.0);
		
		int startPage=(pageNum-1)/5*5+1;
		int endPage=startPage+4;
		
		if(endPage>pageCount) {
			endPage=pageCount;
		}
		
		req.setAttribute("list", list);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		req.setAttribute("pageCount", pageCount);
				
		//리스트으로 이동
		req.getRequestDispatcher("/board/list.jsp").forward(req, resp);
	}
	

}
