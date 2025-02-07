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
	<h1>[ 메인페이지 ]</h1>
	<h2>최신글 목록 top5</h2>
	<table border="1" width="500">
		<tr>
			<th>글번호</th><th>작성자</th><th>제목</th>
		</tr>
		<c:forEach var="chart" items="${chart }">
			<tr>
				<td>${chart.num }</td>
				<td>${chart.writer }</td>
				<td>
					<a href="${pageContext.request.contextPath }/board/detail?num=${chart.num}">${chart.title }</a>
				</td>	
			</tr>
		</c:forEach>
	</table>

	<ul>
		<li><a href="${pageContext.request.contextPath }/board/insert">글등록</a></li>
		<li><a href="${pageContext.request.contextPath }/board/list">글목록</a></li>
	</ul>
</body>
</html>