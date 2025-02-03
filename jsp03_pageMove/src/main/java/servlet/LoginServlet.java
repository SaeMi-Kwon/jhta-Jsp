package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//resp.sendRedirect("login.jsp");  //리다이렉트방식
		
		//포워드 방식으로 페이지 이동하기(이동된 페이지에 request,response객체가 그대로 전달된다.)
		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);
	}
	
	//doPost메소드 오버라이딩 -> id와 pwd가 맞으면 xxx님 반갑습니다. 출력
	//틀리면 아이디 또는 비밀번호가 틀려요 라고 출력되도록
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//사용자가 입력한 데이터 얻어오기
		String id=req.getParameter("id");	
		String pwd=req.getParameter("pwd");
		boolean isMember=false; 

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			con=DriverManager.getConnection(url,"c##scott","tiger");
			String sql="select * from myusers where id=? and pwd=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,pwd);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				isMember=true;
			}
		
		}catch(ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}catch(SQLException s) {
			System.out.println(s.getMessage());
		}finally {
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se){
				System.out.println(se.getMessage());
			}
		}		
		
//		resp.setContentType("text/html;charset=utf-8");  //반드시 지정해줘야함
//		PrintWriter pw=resp.getWriter();   
//		pw.println("<html><head></head><body>");
//		
//		if(isMember) {
//			pw.println("<h1>" + id + "님 반갑습니다.</h>");
//		}else{
//			System.out.println("아이디 또는 비밀번호가 틀려요");
//		}
//		pw.println("</body></html>");
		
		
		/*
		 * 아이디와 비밀번호가 맞으면 member.jsp페이지로 이동하고
		 * 아이디 또는 비밀번호가 틀리면 login.jsp페이지로 이동하고 오류메시지를 div에 출력해 보세요.
		 */
		
		if(isMember) {
			//포워드방식 - 페이지이동(member.jsp)
			req.setAttribute("id", id);  //request스코프에 값 담기
			RequestDispatcher rd = req.getRequestDispatcher("member.jsp");
			rd.forward(req, resp);
			
			//리다이렉트방식 - 페이지이동(member.jsp)
			//member.jsp에서 id값이 출력안됨. request가 유지 되지 않기 때문
			//resp.sendRedirect("member.jsp"); 
		}else {
			req.setAttribute("errMsg", "아이디 또는 비밀번호가 틀려요");
			RequestDispatcher rd1= req.getRequestDispatcher("login.jsp");
			rd1.forward(req, resp);
			
		}
	}

}
