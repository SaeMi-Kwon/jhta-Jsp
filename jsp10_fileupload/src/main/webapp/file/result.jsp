<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>file/result.jsp</title>
</head>
<body>
	<h1>파일업로드 완료!!!</h1>
	전송된 파일명 ${orgfilename }<br>
	저장된 파일명 ${savefilename }<br>
	전송된 파일크기 ${filesize }<br>
	<a href="<%=request.getContextPath() %>/main.jsp">main</a>
</body>
</html>