<%@page import="members.dto.MembersDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>members/update.jsp</title>
</head>
<body>

	<!-- jstl사용해서 update.jsp 만들기  -->
	<h2>회원정보 수정</h2>
	<form action="/jsp06_members/members/update" method="post">
		회원번호 <input type="text" name="num" readonly="readonly" value="${dto.num }"><br>
		이름 <input type="text" name="name" value="${dto.name }"><br>
		전화번호 <input type="text" name="phone" value="${dto.phone }"><br>
		주소 <input type="text" name="addr" value="${dto.addr }"><br>
		가입일 <input type="text" name="regdate" disabled="disabled" value="${dto.regdate }"><br>
		<input type="submit" value="등록">
	</form>

</body>
</html>