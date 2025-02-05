<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member.jsp</title>
</head>
<body>
<%
	//로그인 한 사용자인지 검사
	String id=(String)session.getAttribute("id");

	if(id==null){
%>
	<script type="text/javascript">
		alert("로그인페이지로 이동합니다");
		location.href="login.jsp";
	</script>		
<%		
	}else{
		
%>
	<h1>회원님 반갑습니다</h1>
	<div>로그인 한 사용자만 볼수 있는 페이지입니다.</div>
	
<%
	}
%>	
</body>
</html>