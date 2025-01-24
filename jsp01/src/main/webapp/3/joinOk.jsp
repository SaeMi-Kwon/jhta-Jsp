<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinOk.jsp</title>
</head>
<body>
<%
	//1.사용자가 입력한 정보 얻어오기
	String num=request.getParameter("num");
	String name=request.getParameter("name");
	String phone=request.getParameter("phone");
	String addr=request.getParameter("addr");
	
	//2.사용자정보를 db에 저장하기
	Class.forName("oracle.jdbc.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	
	Connection con=null;
	PreparedStatement pstmt=null;
	try{
		con=DriverManager.getConnection(url,"c##scott","tiger");
		String sql="insert into members values(?,?,?,?,sysdate)";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,num);
		pstmt.setString(2,name);
		pstmt.setString(3,phone);
		pstmt.setString(4,addr);
		pstmt.executeUpdate();
		
		//3.결과를 응답하기
		out.print("<h1>회원가입 성공!</h1>");
		
	}catch(SQLException s){
		out.print("<h1>회원가입 실패!</h1>");
		System.out.println(s.getMessage());
		
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