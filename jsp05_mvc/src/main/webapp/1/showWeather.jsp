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
	//값 꺼내오기
	String result=(String)request.getAttribute("result");
%>
<h1>오늘의 날씨</h1>
<%=result %><br>
<a href="main.jsp">main.jsp</a>
</body>
</html>