<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/insert.jsp</title>
</head>
<!-- 글 등록기능 완성하기 -> 결과 result.jsp 출력 -->
<body>
	<h1>글등록하기</h1>
	<form action="${pageContext.request.contextPath }/board/insert" method="post">
		작성자<br>
		<input type="text" name="writer"><br>
		제목<br>
		<input type="text" name="title"><br>
		내용<br>
		<textarea rows="5" cols="50" name="content"></textarea><br>
		<input type="submit" value="등록"><br>
	</form>
</body>
</html>