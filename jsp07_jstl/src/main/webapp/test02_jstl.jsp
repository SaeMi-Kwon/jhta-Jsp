<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jstl을 사용하기 위한 설정 -->
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test02_jstl.jsp</title>
</head>
<body>
<!-- 변수선언 -->
<c:set var="name" value="홍길동"/> <br>
이름출력 : <c:out value="${name }"/> <br>

<!-- 변수수정 -->
<!-- 동일한 이름으로 변수를 선언하면 변수값이 수정됨 -->
<c:set var="name" value="honggildong"/> <br> 
수정후 이름 : <c:out value="${name }"/> <br>

<%--
	if문
	<c:if test="${조건식}">
		실행할 문장
	</c:if>
--%>

<c:set var="id" value="admin"/>
<c:if test="${id =='admin' }">
	<p>당신은 관리자입니다.</p>
</c:if>
<c:if test="${id !='admin' }">
	<p>당신은 일반회원입니다.</p>
</c:if>

<%--
	<c:choose>
		<c:when test="${조건식1}">
			조건1이 참일때 수행할 문장
		</c:when>
		<c:when test="${조건식2}">
			조건2이 참일때 수행할 문장
		</c:when>
		<c:otherwise>
			조건식이 모두 맞지 않을때 수행할 문장
		</c:otherwise>
	</c:choose>
 --%>
 
 <c:set var="grade" value="GOLD"/>
 <c:choose>
 	<c:when test="${grade == 'GOLD' }">
 		<p>당신의 등급은 GOLD입니다.</p>
 	</c:when>
 	<c:when test="${grade == 'SILVER' }">
 		<p>당신의 등급은 SILVER입니다.</p>
 	</c:when>
 	<c:when test="${grade == 'BRONZE' }">
 		<p>당신의 등급은 BRONZE입니다.</p>
 	</c:when>
 	<c:otherwise>
 		<p>당신은 일반회원입니다.</p>
 	</c:otherwise>
 </c:choose>

</body>
</html>