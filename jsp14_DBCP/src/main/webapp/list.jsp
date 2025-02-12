<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
</head>
<body>
<h1>회원목록</h1>
<table border="1" width="500">
	<tr>
		<th>번호</th><th>이름</th><th>폰번호</th><th>주소</th><th>등록일</th>
	</tr>
	
	<c:forEach var="dto" items="${list }">
	<tr>
		<td>${dto.num }</td>
		<td>${dto.name }</td>
		<td>${dto.phone }</td>
		<td>${dto.addr }</td>
		<td>${dto.regdate }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>