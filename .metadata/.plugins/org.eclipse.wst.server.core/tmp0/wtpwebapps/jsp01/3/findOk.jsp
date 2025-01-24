<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findOk.jsp</title>
</head>
<body>
<%
	int n=Integer.parseInt(request.getParameter("num"));

	Class.forName("oracle.jdbc.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:xe";	
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	try{
		con=DriverManager.getConnection(url,"c##scott","tiger");
		
		String sql="select * from members where num=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, n);
		rs=pstmt.executeQuery();
		
		
		while(rs.next()){
			int num=rs.getInt("num");
			String name=rs.getString("name");
			String phone=rs.getString("phone");
			String addr=rs.getString("addr");
			Date regdate=rs.getDate("regdate");

			//화면에 출력하기
			out.print("num: " + num + "<br>");
			out.print("name: " + name + "<br>");
			out.print("phone: " + phone + "<br>");
			out.print("addr: " + addr + "<br>");
			out.print("regdate: " + regdate + "<br>");
		}
		
	}catch(SQLException s){
		out.print("<h1>회원조회 실패!</h1>");
		System.out.println(s.getMessage());
	}finally{
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		}catch(SQLException se){
			System.out.println(se.getMessage());
		}
	}
	
%>

</body>
</html>