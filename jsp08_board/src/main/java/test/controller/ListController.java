package test.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.dao.BoardDao;
import test.dto.Board;

@WebServlet("/board/list")
public class ListController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//사용자 입력한 값 꺼내오기
		String page=req.getParameter("pageNum");
		String field=req.getParameter("field");
		String keyword=req.getParameter("keyword");
		
		int pageNum=1;  //초기화
		
		if(page!=null) {  //page를 받아오면 int형으로 변환
			pageNum=Integer.parseInt(page);
		}
		
		//게시글 10개씩 가져오기위한 변수설정 (1~10, 11~20 ...)
		//pageNum에 따라 시작행과 마지막행이 결정된다([4] -> 31~40) 
		int startRow=(pageNum-1)*10+1;  //int startRow=(pageNum *10)-9;
		int endRow=startRow+9;
		
		//게시글 조회
		BoardDao dao=new BoardDao();
		ArrayList<Board> list = dao.list(startRow,endRow,field,keyword);
		
		//전체페이지 갯수구하기(총 목록 갯수)
		int pageCount=(int)Math.ceil(dao.getCount(field,keyword)/10.0);
		
		//페이지 목록갯수(10개씩 항목 보여주기위한 변수설정(1~10, 11~20 ...) 
		int startPage=(pageNum-1)/10*10+1;
		int endPage=startPage+9;

		//마지막페이지 20 > 전체목록 13 이라면 마지막페이지는 13으로 한다.
		if(endPage>pageCount) {
			endPage = pageCount;
		}
		
		//값 저장하기
		req.setAttribute("list", list);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("field",field);
		req.setAttribute("keyword", keyword);
		
		//페이지 이동
		req.getRequestDispatcher("/board/list.jsp").forward(req, resp);
	}
}
