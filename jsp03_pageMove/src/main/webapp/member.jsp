<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member.jsp</title>
</head>
<body>
<%
	//request스코프에 담긴 값 꺼내오기
	String id=(String)request.getAttribute("id");
%>
	<h1><%=id %>회원님 반갑습니다!!</h1>
	<a href="index.jsp">index.jsp</a>
</body>
</html>