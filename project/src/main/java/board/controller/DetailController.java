package board.controller;

import java.io.IOException;

import dao.BoardDao;
import dto.BoardDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board/detail")
public class DetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("filenum"));
		
		//해당 글조회
		BoardDao dao=new BoardDao();
		BoardDto detail=dao.findByNum(num);
		
		
		
		String fnum=String.valueOf(detail.getFilenum());
		String writer=detail.getWriter();
		String title=detail.getTitle();
		
		Cookie cookie1=new Cookie("list1",fnum);
		cookie1.setPath("/");
		cookie1.setMaxAge(60);
		resp.addCookie(cookie1);
	
		Cookie cookie2=new Cookie("list2",writer);
		cookie2.setPath("/");
		cookie2.setMaxAge(60);
		resp.addCookie(cookie2);
		
		Cookie cookie3=new Cookie("list3",title);
		cookie3.setPath("/");
		cookie3.setMaxAge(60);
		resp.addCookie(cookie3);
		
		req.setAttribute("detail", detail);
		
		req.getRequestDispatcher("/board/detail.jsp").forward(req, resp);
	}
	
}
