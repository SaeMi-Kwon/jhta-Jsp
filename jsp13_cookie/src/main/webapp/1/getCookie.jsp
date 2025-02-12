<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1/getCookie.jsp</title>
</head>
<body>
<%
	//쿠키 얻어오기
	Cookie[] cookies=request.getCookies();
	if(cookies!=null){
		for(Cookie cookie:cookies){
			String name=cookie.getName();
			String value=cookie.getValue();
			out.print("<div>쿠키이름:" + name + ", 쿠키값:" + value + "</div>");
		}
	}else{
		out.print("<h1>쿠키가 존재하지 않아요</h1>");
	}
%>

</body>
</html>