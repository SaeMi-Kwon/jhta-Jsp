package test.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.dao.BoardDao;
import test.dto.BoardDto;

@WebServlet("/board/update")
public class UpdateController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("num"));
		
		BoardDao dao=BoardDao.getInstance();

		BoardDto dto=dao.findByNum(num);
		
		req.setAttribute("dto", dto);
		
		req.getRequestDispatcher("/board/update.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("num"));
		String writer=req.getParameter("writer");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
//		int ref=Integer.parseInt(req.getParameter("ref"));
//		int lev=Integer.parseInt(req.getParameter("lev"));
//		int step=Integer.parseInt(req.getParameter("step"));
		
		BoardDto dto=new BoardDto(num,writer,title,content,-1,-1,-1);
		
		BoardDao dao=BoardDao.getInstance();
		dao.update(dto);
		
		resp.sendRedirect(req.getContextPath()+"/board/detail?num=" + num);
	}

}
