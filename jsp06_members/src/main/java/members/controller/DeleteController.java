package members.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import members.dao.MembersDao;

@WebServlet("/members/delete")
public class DeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.전송된 삭제할 회원번호 얻어오기
		int num=Integer.parseInt(req.getParameter("num"));
		
		//2.db에서 삭제하기
		MembersDao dao=new MembersDao();
		int n=dao.delete(num);
	
		//3.결과값을 스코프에 저장해서 결과페이지로 이동하기(result.jsp)
//		String result="success";
//		if(n<=0) {
//			result="fail";
//		}
//		//request 스코프에 담기
//		req.setAttribute("result", result);
//		
//		//뷰페이지로 이동
//		req.getRequestDispatcher("/members/result.jsp").forward(req, resp);
		
		
		//db에서 데이터를 얻어와 list.jsp에 출력하는 컨트롤러를 호출한다.
		//dml작업후에는 리다이렉트 방식으로 페이지를 이동한다.
		//리다이렉트방식 : 외부적으로 접근하는방식(컨텍스트명 작성필수)
		resp.sendRedirect(req.getContextPath() + "/members/list");
	}
}
