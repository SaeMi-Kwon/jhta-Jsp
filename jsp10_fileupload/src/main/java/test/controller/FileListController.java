package test.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.dao.FileInfoDao;
import test.dto.FileInfoDTO;

@WebServlet("/file/list")
public class FileListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		FileInfoDao dao=new FileInfoDao();
		ArrayList<FileInfoDTO> list=dao.list();
		req.setAttribute("list", list);
		
		System.out.println(list);
		
		req.getRequestDispatcher("/file/list.jsp").forward(req, resp);
		
	}
	
	
	
}
