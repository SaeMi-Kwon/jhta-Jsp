package test.controller;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import members.dao.MembersDao;
import members.dto.MembersDto;

@WebServlet("/memberInsert")
public class InsertController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/insert.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//쿠키지움
		Cookie cnum=new Cookie("num","");
		cnum.setPath("/");
		cnum.setMaxAge(0);  
		resp.addCookie(cnum);  
		
		Cookie cname=new Cookie("name","");
		cname.setPath("/");
		cname.setMaxAge(60);  
		resp.addCookie(cname);  
		
		Cookie cphone=new Cookie("phone","");
		cphone.setPath("/");
		cphone.setMaxAge(60);  
		resp.addCookie(cphone);  
		
		Cookie caddr=new Cookie("addr","");
		caddr.setPath("/");
		caddr.setMaxAge(60);  
		resp.addCookie(caddr);
		
		
		
		int num=Integer.parseInt(req.getParameter("num"));
		String name=req.getParameter("name");
		String phone=req.getParameter("phone");
		String addr=req.getParameter("addr");
		
		MembersDto dto=new MembersDto(num,name,phone,addr,null);
		
		ServletContext sc=req.getServletContext();
		MembersDao dao=(MembersDao)sc.getAttribute("membersDao");
		req.setAttribute("list", dao.insert(dto));
		
	
		//req.getRequestDispatcher("/memberlist").forward(req, resp);
		
		resp.sendRedirect(req.getContextPath()+"/memberlist");
		
	}

}
