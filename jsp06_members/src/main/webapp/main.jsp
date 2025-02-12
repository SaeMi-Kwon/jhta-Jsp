<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>

<body>
	<ul>
		<!-- jstl문 사용해서 main.jsp 만들기 -->
		<c:choose>
			<%-- <c:when test="${sessionScope.id == null}"> --%>
			<c:when test="${empty sessionScope.id }">
				<li><a href="${cp }/admin/login">관리자로그인</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${cp }/admin/logout">관리자로그아웃</a></li>
			</c:otherwise>
		</c:choose>
		
		<li><a href="${cp }/admin/insert">관리자가입</a></li>
		<li><a href="${cp }/info">체육관소개</a></li>
		
		<!-- 관리자만 이용가능하게 하기 -->
		<li><a href="${cp }/members/join">회원등록</a></li>
		<li><a href="${cp }/members/list">회원목록</a></li>
	</ul>
</body>
</html>