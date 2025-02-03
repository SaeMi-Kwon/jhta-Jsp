<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
<%
	//request스코프에 담긴 값 꺼내오기
	String id=(String)request.getAttribute("id");
	if(id==null) id="";
	
%>
<%-- members 연동해서 회원가입 하는 서블릿 만들고 결과를 출력해 보세요.
	 jsp 출력 -> 가입된 회원정보
--%>

	<h1><%=id %>회원님 반갑습니다!!</h1>

	<h1><a href="login">회원로그인</a></h1>
	<h1><a href="join">회원가입</a></h1>
</body>
</html>