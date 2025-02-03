package jsp02_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//서블릿 내부적으로 호출해서 사용하는 이유는 외부에서 직접적으로 호출할수 없도록 보안역할
/*
 * service : get/post 둘다 사용하기에 검색창에 값을 직접 넘기면 처리도 가능 -> 보안적으로 위험하다.
 * (그래서 get방식과 post방식을 나눠서 처리가 가능하도록 사용함)
 */
@WebServlet("/quiz")
public class QuizServlet extends HttpServlet{
	
	//get방식으로 요청할때 호출됨
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("doGet메소드 호출");
		resp.sendRedirect("quiz.html");   //quiz.html 페이지로 이동
	}
	
	//post방식으로 요청할때 호출됨
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("doPost메소드 호출");
	
		//1.사용자가 입력한 정보 읽어오기
		req.setCharacterEncoding("utf-8");
		int n1=Integer.parseInt(req.getParameter("n1"));
		int n2=Integer.parseInt(req.getParameter("n2"));
		int n3=n1+n2;
			
		//2. 결과를 응답(웹브라우저 출력)하기
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.println("<html><head></head><body>");
		pw.println("<h1>"+ n1 + "+" + n2 + "=" + n3 + "</h1>");
		pw.println("</body></html>");
		
	}
}
