<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>
컨텍스트 경로 <%=request.getContextPath() %>
	<ul>
		
		<%-- 절대경로 (/ : 사용)--%>
		<li><a href="/jsp05_mvc/fortune">오늘의 운세보기</a></li>
		<li><a href="<%=request.getContextPath() %>/weather?day=1">오늘날씨보기</a></li>
		
		<%-- Controller역할 --%>
		<%-- 상대경로 --%>   
		<li><a href="fortune">오늘의 운세보기</a></li>
		<li><a href="weather?day=1">오늘날씨보기</a></li>
		<li><a href="weather?day=2">내일날씨보기</a></li>
		
		<!-- 절대경로로 TestServlet 링크걸기 -->
		<li><a href="<%=request.getContextPath() %>/admin/test">path테스트</a></li>
	</ul>
</body>
</html>