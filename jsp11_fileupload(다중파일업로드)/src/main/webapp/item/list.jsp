<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>item/list.jsp</title>
</head>
<body>
<h1>파일목록</h1>
<table border=1 width="500">
	<tr>
		<th>제품번호</th><th>제품명</th><th>가격</th><th>상세보기</th>
	</tr>
	<c:forEach var="dto" items="${dto }">
	<tr>
		<td>${dto.inum }</td>
		<td>${dto.itemname }</td>
		<fmt:formatNumber var="price" value="${dto.price }" pattern="###,###.##"/>
		<td>${price }원</td>
		<td><a href="<%=request.getContextPath() %>/item/detail?inum=${dto.inum }">보기</a></td>
	</tr>
	</c:forEach>
</table>
<a href="<%=request.getContextPath() %>/main.jsp">메인페이지</a>
</body>
</html>