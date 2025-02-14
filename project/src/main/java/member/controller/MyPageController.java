package member.controller;

import java.io.IOException;

import dao.MemberDao;
import dto.MemberDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member/mypage")
public class MyPageController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//세션아이디 얻어와서 데이터조회
		String id=(String)req.getSession().getAttribute("id");
		
		MemberDao dao=new MemberDao();
		MemberDto dto =dao.select(id);
		req.setAttribute("dto",dto);
		
		req.getRequestDispatcher("/member/mypage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//수정
		String id=(String)req.getSession().getAttribute("id");
		String pwd=req.getParameter("pwd");
		String email=req.getParameter("email");
		
		MemberDto dto=new MemberDto(id,pwd,email,null);
		MemberDao dao=new MemberDao();
		dao.update(dto);
		
		resp.sendRedirect(req.getContextPath()+"/main.jsp");
		
		
	}
}
