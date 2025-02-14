package test.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import test.dao.LoginDao;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		
		LoginDao dao=new LoginDao();
		boolean login=dao.isMember(id, pwd);
		
		if(login) {
			HttpSession session=req.getSession();
			session.setAttribute("id",id);
			resp.sendRedirect(req.getContextPath()+"/main.jsp");
			
		}else {
			req.getRequestDispatcher("login/login.jsp").forward(req, resp);
		}
	}
	
	
}
