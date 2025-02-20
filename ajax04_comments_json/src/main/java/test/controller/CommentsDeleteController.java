package test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.dao.CommentsDao;

@WebServlet("/comments/delete")
public class CommentsDeleteController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("num"));
		
		CommentsDao dao=new CommentsDao();
		int n=dao.delete(num);
		
		//결과를 json로 응답하기
		resp.setContentType("text/plain;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		JSONObject json=new JSONObject();
		
		if(n>0) {
			json.put("result", true);
		}else {
			json.put("result", false);
		}
		
		pw.print(json);
		pw.close();
		
	}
}
