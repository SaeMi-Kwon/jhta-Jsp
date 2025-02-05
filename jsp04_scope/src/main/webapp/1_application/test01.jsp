<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1_test01.jsp</title>
</head>
<body>
<%
	String url="jdbc:oracle:thin:@localhost:1521:xe";

	//application스코프에 저장하기
	application.setAttribute("url",url);
	
	//application스코프에서 값 꺼내오기
	String dbserver=(String)application.getAttribute("url");
%>
데이터베이스 서버 url: <%=dbserver %><br>
<a href="test02.jsp">test02.jsp</a>
</body>
</html>