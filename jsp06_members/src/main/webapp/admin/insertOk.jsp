<%@page import="members.dto.MyusersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin/insertOk.jsp</title>
</head>
<body>
<%
	String result=(String)request.getAttribute("result");
	MyusersDto dto=(MyusersDto)request.getAttribute("dto");
	if(result.equals("success")){
%>
	<h1>관리자 등록 성공</h1>
	<h2>등록된 정보</h2>
	<ul>
		<li>아이디<%=dto.getId() %></li>
		<li>비밀번호<%=dto.getPwd() %></li>
		<li>이메일<%=dto.getEmail() %></li>
	</ul>

<%
	}else{
		out.println("<h2>요청작업 실패!</h2>");
	}
%>

	<a href="/jsp06_members/main.jsp">메인페이지</a>

</body>
</html>