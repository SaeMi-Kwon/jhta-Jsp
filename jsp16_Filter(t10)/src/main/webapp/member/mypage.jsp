<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/mypage.jsp</title>
</head>
<body>
	<h1>mypage</h1>
	<div>${myinfo }</div>
	
	<a href="<%=request.getContextPath() %>/main.jsp">main</a>
</body>
</html>