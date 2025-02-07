<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>
	<ul>
		<%-- <li><a href="<%=request.getContextPath() %>/board/insert">글등록</a></li> --%>
		
		<!-- 글등록기능 완성해보세요. 글등록후 result.jsp에서 결과출력(글등록성공/실패) -->
		<li><a href="${pageContext.request.contextPath }/board/insert">글등록</a></li>
		<li><a href="${pageContext.request.contextPath }/board/list">글목록</a></li>
	</ul>
</body>
</html>