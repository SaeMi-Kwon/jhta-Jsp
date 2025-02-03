package servlet;

import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JoinServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("join.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String num=req.getParameter("num");
		String name=req.getParameter("name");
		String phone=req.getParameter("phone");
		String addr=req.getParameter("addr");
		
		LocalDateTime now = LocalDateTime.now();    
		String dateTime = now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		

		Connection con=null;
		PreparedStatement pstmt=null;
		int n=0;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			
			con=DriverManager.getConnection(url,"c##scott","tiger");
			
			String sql="insert into members values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,num);
			pstmt.setString(2,name);
			pstmt.setString(3,phone);
			pstmt.setString(4,addr);
			pstmt.setString(5, dateTime);
			n=pstmt.executeUpdate();
		
		}catch(ClassNotFoundException ce) {
			System.out.println(ce.getMessage());
			
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			
		}finally {
			try{
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se){
				System.out.println(se.getMessage());
			}
		}
		
		if(n>0) {
			req.setAttribute("num", num);
			req.setAttribute("name", name);
			req.setAttribute("phone", phone);
			req.setAttribute("addr", addr);
			req.setAttribute("regdate", dateTime);
			RequestDispatcher rd = req.getRequestDispatcher("joinOk.jsp");
			rd.forward(req, resp);
			
			
		}else {
			req.setAttribute("errMsg", "동일한 회원번호가 존재합니다.");
			RequestDispatcher rd = req.getRequestDispatcher("join.jsp");
			rd.forward(req, resp);
		}
		
	}

}
