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
<% 
	//request스코프로 값 꺼내오기
	MembersDto dto=(MembersDto)request.getAttribute("dto");
	
%>
	<h2>회원정보 수정</h2>
	<form action="/jsp06_members/members/update" method="post">
		회원번호 <input type="text" name="num" readonly="readonly" value="<%=dto.getNum() %>"><br>
		이름 <input type="text" name="name" value="<%=dto.getName() %>"><br>
		전화번호 <input type="text" name="phone" value="<%=dto.getPhone() %>"><br>
		주소 <input type="text" name="addr" value="<%=dto.getAddr() %>"><br>
		가입일 <input type="text" name="regdate" disabled="disabled" value="<%=dto.getRegdate() %>"><br>
		<input type="submit" value="등록">
	</form>

</body>
</html>