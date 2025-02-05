<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1/showFortune.jsp</title>
</head>
<body>
<%
	//값 꺼내오기
	String result=(String)request.getAttribute("result");
%>
<h1>오늘의 운세</h1>
<%=result %><br>

<%-- 절대경로 --%>
<a href="<%=request.getContextPath() %>/main.jsp">main.jsp</a> 

<%-- 서블릿(controller)을 통해 경로이동하는건 url경로를 기준으로 한다 --%>
<%-- 상대경로 --%>
<a href="main.jsp">main.jsp</a> 
</body>
</html>