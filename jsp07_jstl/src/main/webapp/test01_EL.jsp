<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test01_EL.jsp</title>
</head>
<body>
<%--
	EL(Expression Language) - 수식언어
	1) 형식 : ${표현식}
	2) EL 연산자 : +,-,*,/,%,!,not,empty,mod,<,<=, ....,lt,gt,ge,le,&&,||,and,or,...
	3) EL 내장객체
		requestScope,sessionScope,applicationScope,param,pageContext,paramValues,
		header,cookie,...
 --%>
 
 10+20 = <%=10+20 %> <br>
 10+20 = ${10+20 } <br>
 
 10=20 ${10 eq 20 } <br>
 10>20 ${10 gt 20 } <br>
 10<=20 ${10 le 20 } <br>
 
 
 <%
 	request.setAttribute("username","홍길동");
 	session.setAttribute("id","hello");
 %>
 username : ${requestScope.username } <br>
 id : ${sessionScope.id } <br>
 
 <!-- http://localhost:8080/jsp07_jstl/test01_EL.jsp?num=1 -->
 param : ${param.num }
 
 
 <%--
 	String username=(String)request.getAttribute("username");

 	<%=username %> <br>
 --%> 

</body>
</html>