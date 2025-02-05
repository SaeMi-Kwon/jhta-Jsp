<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인페이지</h1>
	<ul>
<!-- 
	로그인이 안되어있으면 로그인링크가 보여지고
	로그인되었으면 로그아웃링크가 보여지도록 해보세요
-->
<%
	String id=(String)session.getAttribute("id");
	if(id==null){
%>
		<li><a href="login.jsp">로그인</a></li>
<%
	}else{
%>
		<li><a href="logout.jsp">로그아웃</a></li>
<%
	}
%>	
		<li><a href="member.jsp">member페이지</a></li>  <%-- 로그인사용자만 가능 --%>
	</ul>
</body>
</html>