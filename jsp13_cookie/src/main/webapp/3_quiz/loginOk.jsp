<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3_quiz/loginOK.jsp</title>
</head>
<body>
<%
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	String chk=request.getParameter("chk");
	
	if(chk!=null){  //체크박스가 체크인경우 - 아이디와 비밀번호를 쿠키생성해서 담기
		Cookie cookie1=new Cookie("id",id);
		cookie1.setPath("/");
		cookie1.setMaxAge(60*60*24);  //쿠키 유지시간 1일 설정
		response.addCookie(cookie1);  
		
		Cookie cookie2=new Cookie("pwd",pwd);
		cookie2.setPath("/");
		cookie2.setMaxAge(60*60*24);
		response.addCookie(cookie2);
		
	}else{ //체크박스가 체크되지 않는 경우 - 기존에 있는 아이디/비밀번호 쿠키를 삭제하기
		Cookie cookie1=new Cookie("id",id);
		cookie1.setPath("/");
		cookie1.setMaxAge(0);  //쿠키 유지시간 0으로 설정 - 해당 쿠키가 삭제되는것처럼
		response.addCookie(cookie1);  
		
		Cookie cookie2=new Cookie("pwd",pwd);
		cookie2.setPath("/");
		cookie2.setMaxAge(0);
		response.addCookie(cookie2);
	}

%>

아이디: <%=id %><br>
비밀번호: <%=pwd %><br>
체크박스: <%=chk %><br>

</body>
</html>