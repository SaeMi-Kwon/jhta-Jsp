<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin/insert.jsp</title>
</head>
<body>

	<!-- jstl사용해서 list.jsp 만들기 -->
	<h1>관리자 등록하기</h1>

	<form action="/jsp06_members/admin/insert" method="post">
		아이디 <input type="text" name="id" value="${id }">
		
		<!-- formaction : type =submit, image 에서만 사용가능 (form내부에서 action) -->
		<input type="submit" value="아이디중복체크" formaction="/jsp06_members/admin/idcheck">
		<span style="color:red; font-size:0.8em;">${msg }</span><br>
		
		비밀번호 <input type="password" name="pwd" value="${pwd }"><br>
		이메일 <input type="email" name="email" value="${email }"><br>
		<input type="submit" value="등록"><br>
	</form>
</body>
</html>