<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinOk.jsp</title>
</head>
<body>
<%
	//톰캣9이하 버전에서는 post로 전송시 한글이 깨지므로 utf-8로 인코딩해줘야 한다.
	//request.setCharacterEncoding("utf-8");

	String num=request.getParameter("num");
	String name=request.getParameter("name");
	String addr=request.getParameter("addr");
%>

<h1>회원등록완료!!</h1>
num <%=num %><br>
name <%=name %><br>
addr <%=addr %> <br>
</body>
</html>