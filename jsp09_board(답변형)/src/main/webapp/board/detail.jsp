<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/detail.jsp</title>
</head>
<body>
<c:set var="cp" value="${pageContext.request.contextPath }"/>

<h1>상세글보기</h1>
<table border="1" width="500" >
	<tr>
		<td width="100">글번호</td>
		<td>${detail.num } </td>
	</tr>
	<tr>
		<td>작성자</td>
		<td>${detail.writer }</td>
	</tr>
	<tr>
		<td>제목</td>
		<td>${detail.title }</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>
			<div style="width:350px; height:200px;">
				${detail.content }
			</div>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="${cp }/board/insert?num=${detail.num}&ref=${detail.ref}&
			lev=${detail.lev}&step=${detail.step}">답변</a>
		</td>
	</tr>
	
</table>
</body>
</html>