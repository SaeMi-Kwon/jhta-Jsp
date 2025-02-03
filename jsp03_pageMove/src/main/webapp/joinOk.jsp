<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinOk.jsp</title>
</head>
<body>
<table border="1" width="500">
	<tr>
		<th>회원번호</th><th>이름</th><th>전화번호</th><th>주소</th><th>가입일</th>
	</tr>
<%
	String num=(String)request.getAttribute("num");
	String name=(String)request.getAttribute("name");
	String phone=(String)request.getAttribute("phone");
	String addr=(String)request.getAttribute("addr");
	String regdate=(String)request.getAttribute("regdate");

%>

<tr>
	<td><%=num %></td>
	<td><%=name %></td>
	<td><%=phone %></td>
	<td><%=addr %></td>
	<td><%=regdate %></td>
</tr>


</body>
</html>