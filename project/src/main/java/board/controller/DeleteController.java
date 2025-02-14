package board.controller;

import java.io.IOException;

import dao.BoardDao;
import dto.BoardDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board/delete")
public class DeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("filenum"));
		String id=(String)req.getSession().getAttribute("id");
		
		BoardDao dao=new BoardDao();
		boolean n =dao.delete(num,id);		
		
		if(n) {  //삭제성공
			resp.sendRedirect(req.getContextPath()+"/board/list");
			
		}else {  //삭제실패
			BoardDto dto=dao.findByNum(num);
			String writer=dto.getWriter();
			req.setAttribute("writer", writer);
			req.setAttribute("msg", "로그인사용자과 작성자가 일치하지않습니다.");
			req.getRequestDispatcher("/board/result.jsp").forward(req, resp);
		}
		
		
	}
}
