package test.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.dao.BoardDao;
import test.dto.BoardDto;

@WebServlet("/board/list")
public class ListController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String spageNum=req.getParameter("pageNum");
		
		int pageNum=1;
		
		if(spageNum!=null) { 
			pageNum=Integer.parseInt(spageNum);
		}
		
		int endRow=pageNum*10;
		int startRow=endRow-9;

		BoardDao dao = BoardDao.getInstance();
		ArrayList<BoardDto> list= dao.list(startRow,endRow);
		
		//페이지 항목 10개씩 보여주기
		//전체페이지 갯수
		int pageCount=(int)Math.ceil(dao.getCount()/10.0); 
		
		//페이지번호가 어디를 가르켜도 페이지항목 시작은 [1] 가르키게 만든다.  
		int startPage=((pageNum-1)/10*10)+1;
		int endPage=startPage+9;
		
		if(endPage >pageCount){
			endPage=pageCount;
		}
		
		req.setAttribute("list", list);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("pageNum",pageNum);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		
		req.getRequestDispatcher("/board/list.jsp").forward(req, resp);
		
	}
}
