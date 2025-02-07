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

@WebServlet("/")
public class MainController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//최신글 5개를 얻어와서 req에 담고 main.jsp에서 출력하기(답변제외)
		//수정/삭제 기능 구현해 보기
		int pageNum=1;

		int endRow=pageNum*5;
		int startRow=endRow-4;
		
		BoardDao dao=BoardDao.getInstance();
		ArrayList<BoardDto> chart = dao.showFive(startRow, endRow);
		
		System.out.println(chart);
		
		
		req.setAttribute("chart",chart);
		req.getRequestDispatcher("/main.jsp").forward(req, resp);
	}
}
