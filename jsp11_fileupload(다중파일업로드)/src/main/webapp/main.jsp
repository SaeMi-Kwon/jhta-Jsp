<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>
	<ul>
		<li><a href="<%=request.getContextPath() %>/item/insert">제품등록하기</a></li>
		<li><a href="<%=request.getContextPath() %>/item/list">제품목록</a></li>
	</ul>
</body>
</html>