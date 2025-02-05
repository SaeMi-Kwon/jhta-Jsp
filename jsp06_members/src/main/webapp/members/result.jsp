<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>members/result.jsp</title>
</head>
<body>
	<h1>요청작업 완료</h1>
	
<%
	String result=(String)request.getAttribute("result");

	if(result.equals("success")){
		out.print("<h2>요청작업 성공!</h2>");
	}else{
		out.print("<h2>요청작업 실패!</h2>");
	}
%>
<%-- 원래 컨트롤러를 통해 이동해야함 --%>
<a href="/jsp06_members/main.jsp">메인페이지</a> 
</body>
</html>