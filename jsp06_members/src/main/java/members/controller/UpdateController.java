package members.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import members.dao.MembersDao;
import members.dto.MembersDto;

@WebServlet("/members/update")
public class UpdateController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.전송된 조회할 회원번호 얻어오기
		int num=Integer.parseInt(req.getParameter("num"));
				
		//2.db(dao)에서 조회하기
		MembersDao dao=new MembersDao();
		MembersDto dto = dao.findByNum(num);
		
		//3.결과값을 request스코프에 저장해서 포워드방식으로 update.jsp로 페이지이동
		if(dto!=null) {
			req.setAttribute("dto", dto);
			req.getRequestDispatcher("/members/update.jsp").forward(req, resp);
		}else {
			req.setAttribute("result", "not found");
			req.getRequestDispatcher("/members/result.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.전송된 수정할 회원번호 얻어오기
		int num=Integer.parseInt(req.getParameter("num"));
		String name=req.getParameter("name");
		String phone=req.getParameter("phone");
		String addr=req.getParameter("addr");
		
		//2.db(dao)에서 수정하기
		MembersDto dto=new MembersDto(num,name,phone,addr,null);
		MembersDao dao=new MembersDao();
		dao.update(dto);
		
		//3.list.jsp로 페이지이동
		resp.sendRedirect(req.getContextPath() + "/members/list");
	}
}
