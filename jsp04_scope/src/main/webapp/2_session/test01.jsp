<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2_test01.jsp</title>
</head>
<body>
<h1>test01.jsp</h1>
<%
	String username="hello";
	String email="hello@test.com";
	
	session.setMaxInactiveInterval(60);  //세션유지시간 설정-초단위(60초)
	
	//session스코프에 저장하기
	session.setAttribute("username",username);
	session.setAttribute("email",email);
	
	response.sendRedirect("test02.jsp"); //페이지이동(리다이렉트)
%>
<a href="test02.jsp">test02.jsp</a>
</body>
</html>