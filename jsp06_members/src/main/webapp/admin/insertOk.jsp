<%@page import="members.dto.MyusersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin/insertOk.jsp</title>
</head>
<body>
	<!-- jstl사용해서 insertOk.jsp 만들기 -->
	<c:choose>
		<c:when test="${result == 'success' }">
			<h1>관리자 등록 성공</h1>
			<h2>등록된 정보</h2>
			<ul>
				<li>아이디 : ${dto.id }</li>
				<li>비밀번호 : ${dto.pwd }</li>
				<li>이메일 : ${dto.email }</li>
			</ul>
				
		</c:when>
		<c:otherwise>
			<h2>요청작업 실패!</h2>
		</c:otherwise>
	</c:choose>

	<a href="/jsp06_members/main.jsp">메인페이지</a>

</body>
</html>