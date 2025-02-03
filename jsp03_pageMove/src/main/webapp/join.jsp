<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join.jsp</title>
<style type="text/css">
	.err{color:red; font-size: 0.8em;}
</style>
</head>
<body>
<%
	String errMsg=(String)request.getAttribute("errMsg");
	
	if(errMsg==null){
		errMsg="";
	}
%>
	<h1>회원가입</h1>
	<form action="join" method="post">
		회원번호 <input type="text" name="num"><br>
		이름 <input type="text" name="name"><br>
		전화번호 <input type="text" name="phone"><br>
		주소 <input type="text" name="addr"><br>
		<input type="submit" value="등록"><br>
		<div class="err"><%=errMsg %></div>
	</form>
</body>
</html>