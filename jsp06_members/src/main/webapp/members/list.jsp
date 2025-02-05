<%@page import="java.util.ArrayList"%>
<%@page import="members.dto.MembersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>members/list.jsp</title>
</head>
<body>
<!-- jstl사용해서 list.jsp 만들기 -->
<h1>회원목록</h1>
	<table border="1" width="500">
		<tr>
			<th>회원번호</th><th>이름</th><th>전화번호</th><th>주소</th><th>가입일</th>
			<th>삭제</th><th>수정</th>
		</tr>

		<c:forEach var="dto" items="${requestScope.list }">
			<tr>
				<td>${dto.num }</td>
				<td>${dto.name }</td>
				<td>${dto.phone }</td>
				<td>${dto.addr }</td>
				<td>${dto.regdate }</td>
				<td><a href="<%=request.getContextPath() %>/members/delete?num=${dto.num }">삭제</a></td>
				<td><a href="<%=request.getContextPath() %>/members/update?num=${dto.num }">수정</a></td>
			</tr>
		</c:forEach>
		
	</table>
	
	<a href="/jsp06_members/main.jsp">메인페이지</a>
</body>
</html>