<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3_quiz/login.jsp</title>
</head>
<body>
<!-- 아이디와 비밀번호를 자동채우기 기능을 쿠키로 구현해 보세요 -->
<%
	//쿠키 얻어오기
	Cookie[] cooks=request.getCookies();
	String id="";
	String pwd="";
	boolean checked=false;
	
	if(cooks!=null){
		for(Cookie cook:cooks){
			String name=cook.getName();
			if(name.equals("id")){
				id=cook.getValue();
				checked=true;
			}else if(name.equals("pwd")){
				pwd=cook.getValue();
			}
		}
	}

%>
<h1>회원로그인</h1>
<form action="loginOk.jsp" method="post">
	아이디 <input type="text" name="id" value="<%=id %>"><br>
	비밀번호 <input type="password" name="pwd" value="<%=pwd %>"><br>
	<%
		if(checked){
	%>	
			<input type="checkbox" name="chk" checked>자동채우기<br>
	<% 
		}else{
	%>
			<input type="checkbox" name="chk">자동채우기<br>
	<% 
		}
	%>
	<input type="submit" value="로그인">
</form>
</body>
</html>