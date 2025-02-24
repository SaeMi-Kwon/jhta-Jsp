<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/list.jsp</title>
</head>
<body>

<a href="${pageContext.request.contextPath }/index.jsp">메인페이지</a><br><br>

<form action="${pageContext.request.contextPath }/board/list" method="post">
	<select name="field">
		<option value="title">글제목</option>
		<option value="writer">작성자</option>
		<option value="content">글내용</option>
	</select>
	<input type="text" name="keyword">
	<input type="submit" value="검색"> 
</form>

<h1>글목록</h1>
<table border="1" width="700">
	<tr>
		<th>글번호</th><th>작성자</th><th>제목</th><th>내용</th><th>등록일</th>
		<th>수정</th>
	</tr>
	<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.num }</td>
			<td>${dto.writer }</td>
			<td>${dto.title }</td>
			<td>${dto.content }</td>
			<td>${dto.regdate }</td>
			<th><a href="${pageContext.request.contextPath }/board/update?num=${dto.num}">수정</a></th>
		</tr>
	</c:forEach>
</table>



</body>
</html>