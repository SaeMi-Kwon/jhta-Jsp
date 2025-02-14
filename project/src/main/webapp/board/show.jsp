<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/show.jsp</title>
</head>
<h1>최신 본 게시글</h1>
<body>
<table border="1" width="500">
	<tr>
		<th>번호</th><th>작성자</th><th>제목</th>
	</tr>
	<c:forEach var="c" items="${cookies }">
	
	<tr>
		<td>${c.get("list") }</td>
		
		<td><a href="${path }/board/detail?filenum=">${c.get("list") }</a></td>
	</tr>
	</c:forEach>
</table>

</body>
</html>