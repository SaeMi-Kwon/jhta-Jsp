<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join.jsp</title>
</head>
<body>
<!-- 필터를 만들고 인코딩을 utf-8로 설정하도록 해보세요. -->
	<h1>회원가입</h1>
	<form action="joinOk.jsp" method="post">
		회원번호 <input type="text" name="num"><br>
		이름 <input type="text" name="name"><br>
		주소 <input type="text" name="addr"><br>
		<input type="submit" value="가입">
	</form>
</body>
</html>