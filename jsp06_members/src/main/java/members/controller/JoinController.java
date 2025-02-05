package members.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import members.dao.MembersDao;
import members.dao.MyusersDao;
import members.dto.MembersDto;

@WebServlet("/members/join")
public class JoinController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//session스코프에서 id 꺼내오기
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");

		if(id!=null) {  //로그인이 null이 아니면(로그인 되어있으면)
			req.getRequestDispatcher("/members/join.jsp").forward(req, resp);
		}else {
			resp.sendRedirect(req.getContextPath() + "/admin/login");
		}
				
		//req.getRequestDispatcher("/members/join.jsp").forward(req, resp);  //페이지이동
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.사용자가 입력한 정보 읽어오기(input에 작성한 value값 읽어오기)
		int num=Integer.parseInt(req.getParameter("num"));
		String name=req.getParameter("name");
		String phone=req.getParameter("phone");
		String addr=req.getParameter("addr");
		
		//2.회원정보를 DB에 저장하기(dao)
		MembersDto dto=new MembersDto(num,name,phone,addr,null);
		MembersDao dao=new MembersDao();
		int n=dao.insert(dto);
		
		//3.결과값을 스코프에 담고 뷰페이지로 이동하기
		String result="success";
		if(n<=0) {
			result="fail";
		}
		
		//request 스코프에 담기
		req.setAttribute("result", result);
		
		//뷰페이지로 이동
		req.getRequestDispatcher("/members/result.jsp").forward(req, resp);
	}

}
