package test.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.dao.BoardDao;
import test.dto.BoardDto;

@WebServlet("/board/insert")
public class InsertController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String num=req.getParameter("num");
		
		if(num!=null && !num.equals("")) {  //답글을 입력하려는 경우
			BoardDao dao=BoardDao.getInstance();
			
			//원글 정보 얻어오기
			BoardDto dto=dao.findByNum(Integer.parseInt(num));
			req.setAttribute("dto", dto);
		}
		
		req.getRequestDispatcher("/board/insertForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String snum=req.getParameter("num");    //새글이면 빈문자가 넘어올수도 있음
		String writer=req.getParameter("writer");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		int num=0;
		int ref=0;
		int lev=0;
		int step=0;
		
		//답글인 경우
		if(snum!=null && !snum.equals("")) {
			num=Integer.parseInt(snum);
			ref=Integer.parseInt(req.getParameter("ref"));
			lev=Integer.parseInt(req.getParameter("lev"));
			step=Integer.parseInt(req.getParameter("step"));
		}
		
		BoardDto dto = new BoardDto(num,writer,title,content,ref,lev,step);
		BoardDao dao=BoardDao.getInstance();
		int n=dao.insert(dto);
		
		if(n>0) {
			req.setAttribute("result", "success");
		}else {
			req.setAttribute("result", "fail");
		}
		req.getRequestDispatcher("/board/result.jsp").forward(req, resp);
	}
}
