<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1_test02.jsp</title>
</head>
<body>
<h1>test02.jsp</h1>
<%
	//application스코프에서 값 꺼내오기
	String url=(String)application.getAttribute("url");

%>

데이터베이스 서버 url: <%=url %><br>
</body>
</html>