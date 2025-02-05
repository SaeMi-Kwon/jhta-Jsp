<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test01.jsp</title>
</head>
<body>
<h1>3_test01.jsp</h1>
<%
	String username="hello";
	String email="hello@test.com";
	
	request.setAttribute("username",username);
	request.setAttribute("email",email);
	
	//리다이렉트방식으로 페이지를 이동하면 request스코프값은 유지되지 않는다.
	//response.sendRedirect("test02.jsp");  //클라이언트가 요청한것과 같다(새롭게 요청하는 방식)
	
	//forward방식으로 페이지를 이동하면 request스코프값이 유지된다.
	request.getRequestDispatcher("test02.jsp").forward(request,response);
%>
<h2>request스코프에 값을 담았어요</h2>
<a href="test02.jsp">test02.jsp</a>
</body>
</html>