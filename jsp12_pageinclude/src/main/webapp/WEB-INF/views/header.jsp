<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- header.jsp -->
<ul>
	<li><a href="<%=request.getContextPath() %>/home">홈</a></li>
	<li><a href="<%=request.getContextPath() %>/company">회사소개</a></li>
	<li><a href="<%=request.getContextPath() %>/board">게시판</a></li>
	<c:choose>
		<c:when test="${empty sessionScope.id }">
			<li><a href="<%=request.getContextPath() %>/login">로그인</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="<%=request.getContextPath() %>/logout">로그아웃</a></li>
		</c:otherwise>
	</c:choose>
	
</ul>
