package admin.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import members.dao.MyusersDao;
import members.dto.MyusersDto;

@WebServlet("/admin/insert")
public class AdminJoinController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/admin/insert.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		String email=req.getParameter("email");
		
		MyusersDao dao = new MyusersDao();
		MyusersDto dto = new MyusersDto(id,pwd,email,null);
		int n=dao.insert(dto);
		
		String result="success";
		if(n<=0) {
			result="fail";
		}
		req.setAttribute("result", result);
		req.setAttribute("dto",dto);  //여러번 담을수있음
		
		req.getRequestDispatcher("/admin/insertOk.jsp").forward(req, resp);
		
	}
}
