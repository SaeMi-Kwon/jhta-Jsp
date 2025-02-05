package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * MVC (Model View Controller)
 * - 클라이언트의 요청을 컨트롤러가 받아 요청에 따른 비즈니스로직을 처리하기 위한 모델객체를 호출 후
 * 	 모델객체에서 리턴값 결과값을 가지고 뷰페이지로 이동하여 출력하는 구조
 * 
 * < 컨트롤러 >
 * 1. 클라이언트 요청을 받아 요청 분석에 따른 모델객체 호출
 * 2. (모델객체가 리턴한 값을 스코프에 담아) 뷰페이지로 이동
 * 
 */

@WebServlet("/fortune")   //메인페이지에서 서블릿을 호출할때 매핑경로
public class FortuneController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.클라이언트 요청을 받아 요청 분석에 따른 모델객체 호출
		String result="동쪽으로 가면 귀인을 만나리~";
		
		//2.(모델객체가 리턴한 값을 스코프에 담아) 뷰페이지로 이동
		req.setAttribute("result", result);
		
		//3.결과를 응답하기위한 뷰페이지로 이동(request에 값을 담았으므로 forward방식으로 이동한다.)
		RequestDispatcher rd = req.getRequestDispatcher("/1/showFortune.jsp");
		rd.forward(req, resp);
	}
}
