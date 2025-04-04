<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>
	<h1>영화제목</h1>
	<ul>
		<c:forEach var="dto" items="${list }">
			<li>${dto.title } 
				<a href="<%=request.getContextPath() %>/detail?mnum=${dto.mnum }">상세보기</a>
			</li>
		</c:forEach>
	</ul>

	
</body>
</html>