<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3_test02.jsp</title>
</head>
<body>
<%
	////request스코프에서 값 꺼내오기
	String username=(String)request.getAttribute("username");
	String email=(String)request.getAttribute("email");
	
%>
<h1>test02.jsp</h1>
<h2>request스코프에 담긴 값들</h2>
username : <%=username %><br>
email : <%=email %><br>
</body>
</html>