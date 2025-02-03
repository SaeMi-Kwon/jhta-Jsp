<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String num=request.getParameter("num");
	String name=request.getParameter("name");
	String phone=request.getParameter("phone");
	String addr=request.getParameter("addr");

	Connection con=null;
	PreparedStatement pstmt=null;
	
	int n=0;
	
	try{
		Class.forName("oracle.jdbc.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		con=DriverManager.getConnection(url,"c##scott","tiger");
		String sql="update members set name=?,phone=?,addr=? where num=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,name);
		pstmt.setString(2,phone);
		pstmt.setString(3,addr);
		pstmt.setString(4,num);
		n=pstmt.executeUpdate();
		
		if(n>0){
			out.print("<h1>회원수정 성공!</h1>");
		}else{
			out.print("<h1>회원수정 실패!</h1>");
		}
		
%>

	<a href="list.jsp">목록페이지로 이동</a> 

<%
	}catch(SQLException s){
		System.out.println(s.getMessage());
		out.print("<h1>회원수정 실패!</h1>");
		
	}finally{
		try{
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();	
		}catch(SQLException se){
			System.out.println(se.getMessage());
		}
	}

%>
</body>
</html>