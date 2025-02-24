<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/searchList.jsp</title>
</head>
<body>

<a href="${pageContext.request.contextPath }/index.jsp">메인페이지</a><br><br>

<form action="${pageContext.request.contextPath }/board/searchList" method="post">
	<input type="checkbox" name="writer" value="writer">작성자
	<input type="checkbox" name="title" value="title">제목
	<input type="checkbox" name="content" value="content">내용
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
			<th><a href="${pageContext.request.contextPath }/board/update">수정</a></th>
		</tr>
	</c:forEach>
</table>



</body>
</html>