<%@page import="test.listener.SessionCountListener"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>usercount.jsp</title>
</head>
<body>
<%
	int cnt=SessionCountListener.getUserCount();
%>
현재 접속자 수: <%=cnt %>
<h1>우리우리 쇼핑몰 방문을 환영합니다!</h1>

<%-- 
다른 브라우저에서 실행하면 카운트가 올라감
브라우저를 종료한다고해서 종료리스너가 바로 실행되지않는다 
 	-> 세션유지시간이 지난후에 사라지므로 시간이 걸림
 --%>
</body>
</html>