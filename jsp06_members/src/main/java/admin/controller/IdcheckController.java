package admin.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import members.dao.MyusersDao;
import members.dto.MyusersDto;

@WebServlet("/admin/idcheck")
public class IdcheckController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		
		//db에 있는지 없는지 확인
		MyusersDao dao=new MyusersDao();
		int dto=dao.findById(id);
		
		if(dto==1) {
			req.setAttribute("msg", "사용중인 아이디입니다.");
		}else if(dto==0){
			req.setAttribute("msg", "사용가능한 아이디입니다.");
		}else {
			System.out.println("에러발생");
		}
		
		//중복체크후 데이터가 사라지기때문에,request스코프를 통해 사용자가 입력한 값을 저장해둔다.
		req.setAttribute("id", id);
		req.setAttribute("pwd", req.getParameter("pwd"));
		req.setAttribute("email", req.getParameter("email"));

		req.getRequestDispatcher("/admin/insert.jsp").forward(req, resp);
		
		//결과값 넘기기
		//System.out.println("아이디중복확인 컨트롤러..입력된 아이디:" + id);
	}
}
