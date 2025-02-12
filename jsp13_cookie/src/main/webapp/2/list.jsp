<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2/list.jsp</title>
</head>
<body>
	<h1>판매제품목록</h1>
	<ul>
		<li><a href="1.jsp">스마트폰</a></li>
		<li><a href="2.jsp">TV</a></li>
		<li><a href="3.jsp">컴퓨터</a></li>
	</ul>
	<hr>
	<div> <!-- 최근 본 상품 출력 -->
		<h1>최근 본 상품</h1>
		<ul>
		<%
		
			Cookie[] cookies=request.getCookies();
			if(cookies!=null){
				for(Cookie cookie:cookies){
					String name=cookie.getName();
					if(name.startsWith("item")){
						String value=cookie.getValue();		
		%>
			<li><%=value %>
			<a href="delCookie.jsp?name=<%=name %>">삭제1</a>
			<a href="<%=request.getContextPath() %>/2/delCookie?name=<%=name %>">삭제2</a>
			</li>
		<% 	
					}
				}
			}
		%>
		</ul>
</div>
</body>
</html>