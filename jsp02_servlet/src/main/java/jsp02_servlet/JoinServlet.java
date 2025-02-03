package jsp02_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * [ 서블릿 ]
 * - 웹어플리케이션에서 실행되는 자바클래스
 * - 클라이언트의 요청을 받고 응답하는 기능을 갖는다.
 * 
 * - 만드는 방법
 * 	1.HttpServlet 상속받기
 * 	2.service메소드 오버라이딩하기
 * 	3.서블릿 매핑경로 지정하기(html에서는 서블릿 매핑경로로 서블릿을 호출한다.)
 * 	  -> 2가지방식(1.@WebServlet("") / 2.web.xml에 매핑설정 -> 예전방식)
 */

@WebServlet("/join")  //서블릿을 호출할때 사용할 매핑경로(/기호 필수) 설정하기
public class JoinServlet extends HttpServlet{
	/*
	 * HttpServletRequest request : 클라이언트의 요청과 관련된 정보를 얻어옴
	 * HttpServletResponse response : 클라이언트의 응답과 관련된 작업을 할 수 있음
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//1.사용자가 입력한 정보 읽어오기
		request.setCharacterEncoding("utf-8");   //한글사용시 깨짐방지
		String num=request.getParameter("num");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String addr=request.getParameter("addr");
		
		//2. 결과를 응답(웹브라우저 출력)하기
		response.setContentType("text/html;charset=utf-8");  //반드시 지정해줘야함
		PrintWriter pw=response.getWriter();   
		pw.println("<html><head></head><body>");
		pw.println("<p>번호:" + num + "</p>");
		pw.println("<p>이름:" + name + "</p>");
		pw.println("<p>전화번호:" + phone + "</p>");
		pw.println("<p>주소:" + addr + "</p>");
		pw.println("</body></html>");
	}
}
