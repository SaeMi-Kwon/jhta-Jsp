package test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.dao.CommentsDao;
import test.dto.CommentsDTO;

@WebServlet("/comments/list")
public class CommentsListController extends HttpServlet{
	//http://localhost:8081/ajax02/comments/list?mnum=1
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mnum=Integer.parseInt(req.getParameter("mnum"));
		
		CommentsDao dao=new CommentsDao();
		ArrayList<CommentsDTO> list=dao.cList(mnum);
		
		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		
		pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.print("<result>");
		
		for(CommentsDTO dto:list) {
			pw.print("<comm>");
			pw.print("<num>" + dto.getNum() + "</num>");
			pw.print("<mnum>" + dto.getMnum() + "</mnum>");
			pw.print("<id>" + dto.getId() + "</id>");
			pw.print("<comments>" + dto.getComments() + "</comments>");
			pw.print("</comm>");
		}
		
		pw.print("</result>");
		pw.close();
	}
	
}
