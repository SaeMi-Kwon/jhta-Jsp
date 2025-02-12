package test.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/savepoint")
public class CookieController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//쿠키 설정
		String num=req.getParameter("num");
		String name=req.getParameter("name");
		String phone=req.getParameter("phone");
		String addr=req.getParameter("addr");
		
		
		Cookie cnum=new Cookie("num",num);
		cnum.setPath("/");
		cnum.setMaxAge(60);  
		resp.addCookie(cnum);  
		
		Cookie cname=new Cookie("name",name);
		cname.setPath("/");
		cname.setMaxAge(60);  
		resp.addCookie(cname);  
		
		Cookie cphone=new Cookie("phone",phone);
		cphone.setPath("/");
		cphone.setMaxAge(60);  
		resp.addCookie(cphone);  
		
		Cookie caddr=new Cookie("addr",addr);
		caddr.setPath("/");
		caddr.setMaxAge(60);  
		resp.addCookie(caddr);  
		
		
		resp.sendRedirect(req.getContextPath()+"/1.jsp");
	}
	
	
}
