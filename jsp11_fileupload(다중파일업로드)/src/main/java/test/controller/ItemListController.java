package test.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.dao.BItemDao;
import test.dto.BItemDTO;

@WebServlet("/item/list")
public class ItemListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BItemDao itemdao=BItemDao.getInstance();
		ArrayList<BItemDTO> dto =itemdao.list();
		
		req.setAttribute("dto", dto);
		
		req.getRequestDispatcher("/item/list.jsp").forward(req, resp);
	}
	
	
}
