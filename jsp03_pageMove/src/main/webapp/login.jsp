<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
<style type="text/css">
	.err{color:red; font-size: 0.8em;}
</style>
</head>
<body>
<%
	String errMsg=(String)request.getAttribute("errMsg");
	String id=request.getParameter("id");  
	String pwd=request.getParameter("pwd");
	
	if(errMsg==null){
		errMsg="";
		id="";
		pwd="";
	}

%>
	<h1>회원로그인</h1>
	<form action="login" method="post">
		아이디 <input type="text" name="id" value="<%=id %>"><br>
		비밀번호 <input type="password" name="pwd" value="<%=pwd %>"><br>
		<input type="submit" value="로그인"><br>
		<div class="err"><%=errMsg %></div>
	</form>
</body>
</html>