package jsp02_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sum")   //서블릿 매핑경로 지정하기
public class SumServlet extends HttpServlet {
	
	//service메소드는 get방식 / post방식 모두 요청처리를 한다.
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
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
