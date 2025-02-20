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
import test.dto.CommentsDTO;

@WebServlet("/comments/insert")
public class CommentsInsertController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mnum=Integer.parseInt(req.getParameter("mnum"));
		String id=req.getParameter("id");
		String comments=req.getParameter("comments");
		
		CommentsDTO dto=new CommentsDTO(0,mnum,id,comments);
		CommentsDao dao=new CommentsDao();
		int n=dao.insert(dto);
		
		//결과를 json로 응답하기
		resp.setContentType("text/plain;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		JSONObject json=new JSONObject();
		
		if(n>0) {
			json.put("result",true);
			
		}else {
			json.put("result",false);
		}
		
		pw.print(json);
		pw.close();

	}

}
