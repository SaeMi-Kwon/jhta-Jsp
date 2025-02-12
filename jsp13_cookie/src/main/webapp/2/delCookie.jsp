<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2/delCookie.jsp</title>
</head>
<body>

<%
	String cookieName=request.getParameter("name");
	Cookie cookie=new Cookie(cookieName,"");  
	cookie.setMaxAge(0);  
	response.addCookie(cookie);
	
	response.sendRedirect("list.jsp");
%>


</body>
</html>