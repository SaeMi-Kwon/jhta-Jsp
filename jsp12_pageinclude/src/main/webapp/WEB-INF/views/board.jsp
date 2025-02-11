<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- board.jsp -->
<div>
<h1>게시판 입니다</h1>
	<table border="1">
		<tr>
			<th>번호</th><th>제목</th><th>내용</th>
		</tr>
		<c:forEach var="b" items="${list }">
		<tr>
			<td>1</td>
			
			<td>${b }</td>
			<td>테스트입니다</td>
		</tr>
		</c:forEach>
	
	</table>
</div>