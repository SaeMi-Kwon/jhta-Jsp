<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logout.jsp</title>
</head>
<body>
<%
	//session.removeAttribute("id"); //모든 세션 영역을 지운다.
	session.invalidate(); //세션영역 무효화
%>
<h1>로그아웃되었습니다</h1>
<a href="main.jsp">메인페이지</a>
</body>
</html>