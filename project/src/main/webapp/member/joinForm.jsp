<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/joinForm.jsp</title>
</head>
<body>
<h1>회원가입</h1>
<form action="${path }/member/insert" method="post">
	아이디 <input type="text" name="id" value=${cookie.id.value }>
	<input type="submit" value="중복체크" formaction="${path }/member/idcheck">
	<span style="color:red;">${param.msg }</span><br>
	비밀번호 <input type="password" name="pwd" value=${cookie.pwd.value }><br>
	이메일 <input type="email" name="email" value=${cookie.email.value }><br>
	<input type="submit" value="가입">
</form>
</body>
</html>