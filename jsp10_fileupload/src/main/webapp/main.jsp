<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>
<!-- 개발경로는 webapp 이후(밑에서부터) 폴더(파일)부터 시작한다 -->
main.jsp의 실제경로(절대경로) : <%=application.getRealPath("/upload") %><br>
	<ul>
		<li><a href="<%=request.getContextPath() %>/file/upload">파일첨부</a></li>
		<li><a href="<%=request.getContextPath() %>/file/list">파일목록</a></li>
	</ul>
</body>
</html>