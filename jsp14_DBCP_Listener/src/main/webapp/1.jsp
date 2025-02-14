<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1.jsp</title>
</head>
<body>
<a href="<%=request.getContextPath() %>/member">member1</a><br>
<a href="${cp }/member">member2</a><br>
<!-- 회원목록을 출력할수 있도록 컨트롤러를 만들고 list.jsp에서 출력해 보세요. -->
<a href="${cp }/memberlist">회원목록</a><br>

<!-- 
	회원가입기능 완성해 보세요.
	임시저장후 나가기 기능을 추가해보세요(쿠키사용)
 -->
<a href="${cp }/memberInsert">회원가입</a>
</body>
</html>