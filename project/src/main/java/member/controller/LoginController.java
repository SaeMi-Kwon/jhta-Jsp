package member.controller;

import java.io.IOException;

import dao.MemberDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member/login")
public class LoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/member/loginForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		
		MemberDao dao=new MemberDao();
		boolean result =dao.isMember(id, pwd);
		
		if(result==true) {  
			HttpSession session=req.getSession(); 
			session.setAttribute("id", id);
			resp.sendRedirect(req.getContextPath() + "/main.jsp");  
			
		}else {
			req.setAttribute("msg", "아이디 또는 비밀번호가 일치하지 않아요");
			req.getRequestDispatcher("/member/loginForm.jsp").forward(req, resp);
		}
		
	}
}
