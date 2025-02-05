package admin.controller;

import java.io.IOException;

import jakarta.annotation.security.RolesAllowed;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import members.dao.MyusersDao;

@WebServlet("/admin/login")
public class LoginController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/admin/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		
		MyusersDao dao=new MyusersDao();
		boolean result =dao.isAdmin(id, pwd);
		
		if(result) {  //아이디와 비밀번호가 일치하는 경우
			//세션에 아이디저장(객체를 통해 얻어와야한다)
			HttpSession session=req.getSession(); //세션객체 얻어오기
			session.setAttribute("id", id);
			
			//메인페이지로 이동
			resp.sendRedirect(req.getContextPath() + "/main.jsp");  //리다이렉트(컨텍스명 필수)
			
		}else {  //아이디 또는 비밀번호가 틀린경우
			//오류메시지를 request스코프에 담기
			req.setAttribute("errMsg", "아이디 또는 비밀번호가 일치하지 않아요");
			
			//로그인 페이지로 이동
			req.getRequestDispatcher("/admin/login.jsp").forward(req, resp);
		}
	}

}
