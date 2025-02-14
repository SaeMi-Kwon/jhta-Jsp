<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/loginForm.jsp</title>
</head>
<body>
<h1>로그인</h1>
<form action="${path }/member/login" method="post">
	아이디 <input type="text" name="id"><br>
	비밀번호 <input type="password" name="pwd"><br>
	<div><span style="color:red;">${msg }</span></div><br>
	<input type="submit" value="로그인">
</form>
</body>
</html>