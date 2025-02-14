package test.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.db.ConnectionPool;

@WebServlet("/member")
public class MemberController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//컨넥션 잘 받아왔는지 확인
		try {	
//			ConnectionPool cp=new ConnectionPool();  
//			Connection con=cp.getConnection();  //컨넥션 얻어오기
//			System.out.println("con:" + con);
//			cp.closeConnection(con);  //컨넥션 반환하기
			
			ConnectionPool cp=(ConnectionPool)req.getServletContext().getAttribute("conPool");
			Connection con=cp.getConnection();  //컨넥션 객체 얻어오기
			System.out.println("con:" + con);
			cp.closeConnection(con);  //컨넥션 객체 반환하기
			req.setAttribute("con", con);
			req.getRequestDispatcher("/result.jsp").forward(req, resp);
			
		}catch(SQLException s) {
			System.out.println(s.getMessage());
		}
	
	}
}
