<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/insert.jsp</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty param.num }">
			<h1>글등록하기</h1>
		</c:when>
		<c:otherwise>
			<%-- <h1>글번호 ${param.num }에 대한 답글등록하기</h1> --%>
			
			<p>원글제목 : ${dto.title }</p>
			<div>
				원글내용
				<div style='width:300px; height:200px;background-color:#f7f7f7'>${dto.content }</div>
			</div>
			<h2>답변글 등록하기</h2>
		</c:otherwise>
	</c:choose>

	<form action="${pageContext.request.contextPath }/board/insert" method="post">
		<!-- 부모글 정보 보내기 -->
		<input type="hidden" name="num" value="${param.num }">
		<input type="hidden" name="ref" value="${param.ref }">
		<input type="hidden" name="lev" value="${param.lev }">
		<input type="hidden" name="step" value="${param.step }">
	
		작성자<br>
		<input type="text" name="writer"><br>
		제목<br>
		<input type="text" name="title"><br>
		내용<br>
		<textarea rows="5" cols="50" name="content"></textarea><br>
		<input type="submit" value="등록"><br>
	</form>
</body>
</html>