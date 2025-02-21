<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/result.jsp</title>
</head>
<body>
	<c:choose>
		<c:when test="${requestScope.result == 1 }">
			<h1>글등록 성공!</h1>
		</c:when>
		<c:otherwise>
			<h1>글등록 실패!</h1>
		</c:otherwise>
	</c:choose>
	
	<a href="${pageContext.request.contextPath }/index.jsp">main</a>
</body>
</html>
