<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>
<%	
	String id=(String)session.getAttribute("id");

	if(id==null){ //로그인이 안한 상태
%>
	<ul>
		<!-- 로그아웃기능 추가해 보세요 -->
		<li><a href="/jsp06_members/admin/login">관리자로그인</a></li>
<%
	}else{   //로그인을 한 상태
%>
		<li><a href="/jsp06_members/admin/logout">관리자로그아웃</a></li>
<%
	}
%>		
		<li><a href="/jsp06_members/admin/insert">관리자가입</a></li>
		<li><a href="/jsp06_members/info">체육관소개</a></li>
		
		<!-- 관리자만 이용가능하게 하기 -->
		<li><a href="/jsp06_members/members/join">회원등록</a></li>
		<li><a href="/jsp06_members/members/list">회원목록</a></li>
	</ul>
</body>
</html>