package test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.dao.CommentsDao;

import test.dto.CommentsDTO;

@WebServlet("/comments/list")
public class CommentsListController extends HttpServlet{
	//http://localhost:8081/ajax04_comments_json/comments/list?mnum=1&pageNum=2
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mnum=Integer.parseInt(req.getParameter("mnum"));
		
		int pageNum=1;
		String page=req.getParameter("pageNum");
		
		if(page!=null) {
			pageNum=Integer.parseInt(page);
		}
		
		CommentsDao dao=new CommentsDao();
		
		//페이지갯수구하기 - 한페이지에 글은 5개씩 보임
		int pageCount= (int)Math.ceil(dao.getCount(mnum)/5.0);
		
		//현재 페이지 번호가 총 페이지수 보다 클 때
		//사용자가 요청한 페이지번호가 총 페이지수 보다 크면, 마지막 페이지로 자동으로 설정
		if(pageNum>pageCount) pageNum=pageCount; 
		
		int startRow=(pageNum-1)*5+1;   
		int endRow=startRow+4;
		
		int startPage=(pageNum-1)/5*5+1;
		int endPage=startPage+4;
		
		if(endPage>pageCount) {
			endPage=pageCount;
		}
		ArrayList<CommentsDTO> list =dao.cList(mnum, startRow, endRow);
		
		JSONArray arr=new JSONArray(list);
		JSONObject json=new JSONObject();
		json.put("list", arr);
		
		//페이징처리에 관련된 데이터도 json에 담아 응답하기
		json.put("pageCount", pageCount);
		json.put("startPage", startPage);
		json.put("endPage", endPage);
		json.put("pageNum", pageNum);
		
		resp.setContentType("text/plain;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.print(json);
		pw.close();
		
	}
}
