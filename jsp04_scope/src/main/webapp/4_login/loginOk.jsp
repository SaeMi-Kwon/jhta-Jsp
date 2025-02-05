<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginOk.jsp</title>
</head>
<body>
<%
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	
	if(id!=null && id.equals("hello") && pwd!=null && pwd.equals("1234")){
		//세션에 id저장하기
		session.setAttribute("id",id);
%>
	<h1>로그인 성공</h1>
	<a href="main.jsp">main.jsp</a>
<%		
	}else{
%>
	<script type="text/javascript">
		alert("아이디 또는 비밀번호가 맞지 않아요");
		history.go(-1);  //이전 페이지로 이동 (1 : 다음페이지)
	</script>
<%
	}
%>

</body>
</html>