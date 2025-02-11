package test.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import test.dao.MyusersDao;

@WebServlet("/login")
public class LoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("content", "/WEB-INF/views/login.jsp");
		req.getRequestDispatcher("/WEB-INF/views/layout.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//id,pwd 얻어오기
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		
		//db
		MyusersDao dao=MyusersDao.getInstance();
		int n=dao.check(id, pwd);
		
		if(n>0) {
			HttpSession session=req.getSession();
			session.setAttribute("id",id);
			resp.sendRedirect(req.getContextPath()+"/home");
			
		}else {
			req.setAttribute("content", "/WEB-INF/views/login.jsp");
			req.getRequestDispatcher("/WEB-INF/views/layout.jsp").forward(req, resp);
		}
		
		
		
	}
}
