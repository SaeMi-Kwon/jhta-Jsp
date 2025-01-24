<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>join.jsp</title>
</head>
<body>
<%
	//사용자가 입력한 데이터 얻어오기
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
%>
<h1>사용자가 입력한 정보</h1>
id : <%=id %><br>
pwd : <%=pwd %><br>

<%	//hobby라는 이름으로 전송된 데이터들이 배열로 만들어짐
	String[] hobby=request.getParameterValues("hobby");
	out.print("선택된 취미<br>");
	for(String h:hobby){
		out.print(h + "<br>");
	}
	
	//사는지역도 출력해 보세요
	String addr=request.getParameter("addr");
%>
사는지역 <%=addr %>

</body>
</html>