<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String n1=request.getParameter("n1");
	String n2=request.getParameter("n2");
	
	int sum=Integer.parseInt(n1) + Integer.parseInt(n2);
%>

<%=n1%>+ <%=n2%> = <%=sum %>

</body>
</html>