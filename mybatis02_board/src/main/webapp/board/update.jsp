<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/update.jsp</title>
</head>
<body>
	<h1>글수정하기</h1>
	<form action="${pageContext.request.contextPath }/board/update" method="post">
		글번호<br>
		<input type="text" name="num" readonly="readonly"><br>
		작성자<br>
		<input type="text" name="writer" readonly="readonly"><br>
		제목<br>
		<input type="text" name="title"><br>
		내용<br>
		<textarea rows="5" cols="50" name="content"></textarea><br>
		<input type="submit" value="수정"><br>
	</form>
</body>
</html>