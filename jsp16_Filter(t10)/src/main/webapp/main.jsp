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
	<ul>
		<c:choose>
			<c:when test="${empty sessionScope.id }">
				<li><a href="<%=request.getContextPath() %>/login">로그인</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="<%=request.getContextPath() %>/logout">로그아웃</a></li>
			</c:otherwise>
		</c:choose>

		<!-- 로그인사용자만 가능한 페이지 -->
		<li><a href="<%=request.getContextPath() %>/member/list">회원목록</a></li>
		<li><a href="<%=request.getContextPath() %>/member/mypage">마이페이지</a></li>
		
		<li><a href="<%=request.getContextPath() %>/member/1.jsp">member/1.jsp</a></li>
		<li><a href="<%=request.getContextPath() %>/member/2.jsp">member/2.jsp</a></li>
		<li><a href="<%=request.getContextPath() %>/board/1.jsp">board/1.jsp</a></li>
	</ul>
</body>
</html>