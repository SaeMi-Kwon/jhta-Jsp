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
<title>delete.jsp</title>
</head>
<body>
<%
	int num=Integer.parseInt(request.getParameter("num"));
	
	Connection con=null;
	PreparedStatement pstmt=null;
	try{
		Class.forName("oracle.jdbc.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		con=DriverManager.getConnection(url,"c##scott","tiger");
		String sql="delete from members where num=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1,num);
		pstmt.executeUpdate();
		
		//out.print("<h1>회원가입 성공!</h1>");
		response.sendRedirect("list.jsp");  //페이지이동(브라우저 출력하는 코드는 실행이 안됨)
		
	}catch(SQLException s){
		//out.print("<h1>회원가입 실패!</h1>");

%>
	<script>
		alert("회원삭제 실패!");
		location.href="list.jsp";  //페이지이동(브라우저 출력하는 코드도 실행가능함)
	</script>	
		
<%		
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