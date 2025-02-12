package test.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/2/delCookie")
public class DelCookieController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cookieName=req.getParameter("name");
		Cookie cookie=new Cookie(cookieName,"");  
		cookie.setMaxAge(0);  
		resp.addCookie(cookie);
		
		resp.sendRedirect(req.getContextPath() + "/2/list.jsp");
	}
}
