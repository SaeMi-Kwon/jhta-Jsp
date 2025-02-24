<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<!-- 글등록기능/글목록 기능 완성해 보세요 -->
		<li><a href="${pageContext.request.contextPath }/board/insert">글등록</a></li>
		<li><a href="${pageContext.request.contextPath }/board/list">글목록</a></li>
		<li><a href="${pageContext.request.contextPath }/board/searchList">검색</a></li>
	</ul>
</body>
</html>