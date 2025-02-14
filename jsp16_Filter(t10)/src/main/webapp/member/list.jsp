<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/list.jsp</title>
</head>
<body>
	<h1>회원목록</h1>
	<c:forEach var="name" items="${list }">
		<div>${name }</div>
	</c:forEach>
	
	<a href="<%=request.getContextPath() %>/main.jsp">main</a>
</body>
</html>