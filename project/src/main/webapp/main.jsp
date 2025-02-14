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
<h1>메인페이지</h1>
<ul>
	<li><a href="${path }/member/insert">회원가입</a></li>
	
	<li><a href="${path }/board/insert">게시글작성</a></li>
	<li><a href="${path }/board/list">게시글목록</a></li>
	<li><a href="${path }/board/show">최신에 본 게시글</a></li>
	
	<c:choose>
		<c:when test="${empty sessionScope.id }">
			<li><a href="${path }/member/login">로그인</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="${path }/member/mypage">마이페이지</a></li>
			<li><a href="${path }/member/logout">로그아웃</a></li>
		</c:otherwise>
	</c:choose>
</ul>

</body>
</html>