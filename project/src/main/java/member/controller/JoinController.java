package member.controller;

import java.io.IOException;

import dao.MemberDao;
import dto.MemberDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/insert")
public class JoinController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/member/joinForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//쿠키 제거
		Cookie cookie1=new Cookie("id","");
		cookie1.setPath("/");
		cookie1.setMaxAge(0);  
		resp.addCookie(cookie1);
		
		Cookie cookie2=new Cookie("pwd","");
		cookie2.setPath("/");
		cookie2.setMaxAge(0);  
		resp.addCookie(cookie2);
		
		Cookie cookie3=new Cookie("email","");
		cookie3.setPath("/");
		cookie3.setMaxAge(0);  
		resp.addCookie(cookie3);
		

		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		String email=req.getParameter("email");
		
		MemberDto dto=new MemberDto(id,pwd,email,null);
		
		MemberDao dao=new MemberDao();
		
		int n=dao.insert(dto);
		
		if(n>0) {  //저장 완료
			resp.sendRedirect(req.getContextPath()+"/main.jsp");
		}else {  //저장실패
			resp.sendRedirect(req.getContextPath()+"/member/insert");
		}
		
		
	}
	
}
