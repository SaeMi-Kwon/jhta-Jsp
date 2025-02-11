<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2/main.jsp</title>
</head>
<body>
<%@include file="sample.jsp" %> <!-- 페이지 삽입하기 (코드 자체(자바코드)가 삽입) -->
<%
	out.print("name:" + name);  //변수사용가능
%>
<div>main.jsp페이지입니다..</div>
<p>이번 대책은 산림 내 무속 행위, 달집태우기 등으로 인한 산불 피해를 최소화하기 위해 마련됐다.</p>
</body>
</html>