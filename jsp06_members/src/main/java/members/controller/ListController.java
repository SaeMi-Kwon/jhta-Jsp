package members.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import members.dao.MembersDao;
import members.dto.MembersDto;

@WebServlet("/members/list")
public class ListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//session스코프에서 id 꺼내오기
		String id=(String)req.getSession().getAttribute("id");
		
		if(id==null) {  //로그인이 안되어있으면(로그아웃 상태)
			resp.sendRedirect(req.getContextPath() + "/admin/login");
		}else {
			MembersDao dao=new MembersDao();
			ArrayList<MembersDto> list= dao.selectAll();
			//스코프에 담기
			req.setAttribute("list", list);
			req.getRequestDispatcher("/members/list.jsp").forward(req, resp);
		}
	}
	
}
