<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin/login.jsp</title>
</head>
<body>
<%--
	String errMsg=(String)request.getAttribute("errMsg");

	if(errMsg==null) errMsg="";
--%>
	<h1>관리자로그인</h1>
	<form action="/jsp06_members/admin/login" method="post">
		아이디 <input type="text" name="id"><br>
		비밀번호 <input type="password" name="pwd"><br>
		<%-- <div><%=errMsg %></div> --%>
		
		<%-- EL표현식 : 스코프의 값들을 깔끔하게 꺼내올수있다 --%>
		<div>${requestScope.errMsg}</div>
		
		<input type="submit" value="로그인"><br>
	</form>
</body>
</html>