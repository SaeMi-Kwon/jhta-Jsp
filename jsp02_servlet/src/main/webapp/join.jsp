<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join.jsp</title>
</head>
<body>
	<h1>회원가입</h1>
	<%-- action="join" --> /기호 사용안함 --%>
	<form action="join" method="post">
		회원번호 <input type="text" name="num"><br>
		이름 <input type="text" name="name"><br>
		전화번호 <input type="text" name="phone"><br>
		주소 <input type="text" name="addr"><br>
		<input type="submit" value="가입"><br>
	</form>
</body>
</html>