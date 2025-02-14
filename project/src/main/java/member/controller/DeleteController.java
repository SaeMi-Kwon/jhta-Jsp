package member.controller;

import java.io.IOException;

import dao.MemberDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member/delete")
public class DeleteController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=(String)req.getSession().getAttribute("id");
		
		MemberDao dao=new MemberDao();
		boolean n=dao.delete(id);
	
		if(n) { //성공
			//아이디세션지우기 
			req.getSession().invalidate();
		}
		resp.sendRedirect(req.getContextPath()+"/main.jsp");
		
	}
	
}
