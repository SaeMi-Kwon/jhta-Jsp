<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/result.jsp</title>
</head>
<body>
	<h1>요청 실패했습니다.</h1>
	
	<div>
	<p>작성자 : ${writer }</p>
	<p>접속 아이디: ${sessionScope.id }</p>
	<span style="color: red; font-size: 20px">${msg }</span>
	</div>
	<br>
	<a href="${path }/board/list">리스트목록으로 돌아가기</a>
</body>
</html>