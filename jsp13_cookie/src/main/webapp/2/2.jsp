<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2/2.jsp</title>
</head>
<body>
<h1>TV상세페이지</h1>
<ul>
	<li>모델명:xxxx</li>
	<li>가격:xxxxX</li>
	<li>제조사:LG</li>
</ul>

<%-- 쿠키에 정보 담기 --%>
<%
	Cookie cookie=new Cookie("item2","TV");
	cookie.setMaxAge(60*3);
	response.addCookie(cookie);
%>
	<a href="list.jsp">제품목록페이지</a>
</body>
</html>