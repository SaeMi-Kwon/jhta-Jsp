package test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.dao.CommentsDao;
import test.dto.CommentsDTO;

@WebServlet("/comments/insert")
public class CommentsInsertController extends HttpServlet{
	//http://localhost:8081/ajax02/comments/insert?id=hello&comments=good&mnum=1
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String comments=req.getParameter("comments");
		int mnum=Integer.parseInt(req.getParameter("mnum"));
		
		CommentsDao dao=new CommentsDao();
		int n=dao.insert(new CommentsDTO(0,mnum,id,comments));
		
		//결과를 xml로 응답하기
		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		
		pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.print("<result>");
		
		if(n>0) {
			pw.print("<code>success</code>");
		}else {
			pw.print("<code>fail</code>");
		}
		
		pw.print("</result>");
		pw.close();
	}
}
