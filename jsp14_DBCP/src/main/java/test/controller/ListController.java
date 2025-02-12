package test.controller;

import java.io.IOException;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import members.dao.MembersDao;


@WebServlet("/memberlist")
public class ListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//내가 해본 코드
		//MembersDao dao=(MembersDao)req.getServletContext().getAttribute("membersDao");
		//ArrayList<MembersDto> dto=dao.selectAll();
		//req.setAttribute("list", dto);
		
		ServletContext sc=req.getServletContext();
		MembersDao dao=(MembersDao)sc.getAttribute("membersDao");
		req.setAttribute("list", dao.selectAll());
		
		req.getRequestDispatcher("/list.jsp").forward(req, resp);
	}
}
