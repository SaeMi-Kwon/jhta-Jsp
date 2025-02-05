<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2_test02.jsp</title>
</head>
<body>
<h1>test02.jsp</h1>
<%
	//session스코프에서 값 꺼내오기
	String username=(String)session.getAttribute("username");
	String email=(String)session.getAttribute("email");

%>
<h2>세션스코프에 저장된 값들</h2>
username : <%=username %><br>
email : <%=email %><br>
</body>
</html>