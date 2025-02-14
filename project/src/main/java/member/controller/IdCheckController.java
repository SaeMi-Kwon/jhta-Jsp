package member.controller;

import java.io.IOException;
import java.net.URLEncoder;

import dao.MemberDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/member/idcheck")
public class IdCheckController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		String email=req.getParameter("email");

		
		MemberDao dao=new MemberDao();
		boolean check=dao.findById(id);
		
		String msg="";
		if(check==true) {
			msg="사용중인 아이디입니다.";
			
		}else {
			msg="사용 가능한 아이디입니다.";
		}
		
		//쿠키
		Cookie cookie1=new Cookie("id",id);
		cookie1.setPath("/");
		cookie1.setMaxAge(30);  
		resp.addCookie(cookie1);
		
		Cookie cookie2=new Cookie("pwd",pwd);
		cookie2.setPath("/");
		cookie2.setMaxAge(30);  
		resp.addCookie(cookie2);
		
		Cookie cookie3=new Cookie("email",email);
		cookie3.setPath("/");
		cookie3.setMaxAge(30);  
		resp.addCookie(cookie3);
		
			
		resp.sendRedirect(req.getContextPath() 
				+ "/member/joinForm.jsp?msg=" + URLEncoder.encode(msg, "UTF-8"));
		
	}
	
}
