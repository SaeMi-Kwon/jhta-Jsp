<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert.jsp</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="${cp }/memberInsert" method="post">
		회원번호 <input type="text" name="num" value=${cookie.num.value }><br>
		이름 <input type="text" name="name" value=${cookie.name.value }><br>
		전화번호 <input type="text" name="phone" value=${cookie.phone.value }><br>
		주소 <input type="text" name="addr" value=${cookie.addr.value }><br>
		<input type="submit" value="가입">
		<input type="submit" value="임시저장후 페이지나가기" formaction="${cp }/savepoint">
	</form>
</body>
</html>