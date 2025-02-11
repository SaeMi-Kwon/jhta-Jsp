package test.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.dao.BItemDao;
import test.dto.BItemJoinDTO;


@WebServlet("/item/detail")
public class ItemDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int inum=Integer.parseInt(req.getParameter("inum"));
		
		BItemDao itemdao=BItemDao.getInstance();
		
		BItemJoinDTO dto=itemdao.detail(inum);
		
		req.setAttribute("dto", dto);
		
		System.out.println("상세보기==>" + dto);
		
		req.getRequestDispatcher("/item/detail.jsp").forward(req, resp);
		
	}
}
