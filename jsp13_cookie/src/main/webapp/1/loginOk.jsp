<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1/loginOk.jsp</title>
</head>
<body>
<%
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	
	//쿠키생성해서 아이디 담기
	Cookie cookie1=new Cookie("id",id);
	cookie1.setPath("/");  //루트 경로("/")를 포함한 하위경로에 쿠키가 전달된다.
	cookie1.setMaxAge(60*2);  //쿠키유지시간 설정(초단위) - 2분지정
	response.addCookie(cookie1);  //응답객체에 쿠키 담기
	
	//path를 지정하지 않으면 쿠키를 담은 경로로만 쿠키가 전달된다.
	Cookie cookie2=new Cookie("pwd",pwd);
	cookie2.setMaxAge(60*2);  //쿠키유지시간 설정(초단위) - 2분지정
	response.addCookie(cookie2);  //응답객체에 쿠키 담기
	
%>

	<h1>쿠키가 생성되었습니다..</h1>
	<a href="getCookie.jsp">쿠키보러가기</a>
	
</body>
</html>