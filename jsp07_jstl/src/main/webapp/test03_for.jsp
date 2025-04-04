<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test03_for.jsp</title>
</head>
<body>
<%--
<c:forEach var="변수" begin="시작값" end="끝값" step="증가값">
	반복실행할 문장
</c:forEach>
 --%>
 
<c:forEach var="i" begin="1" end="100" step="1">
	<c:out value="${i }"/>
</c:forEach>

<c:forEach var="i" begin="1" end="100" step="1">
	<c:set var="sum" value="${sum+i }"/>
</c:forEach>

<br>
1부터 100까지 합 : ${sum } <br>


<!-- 구구단 출력하기
2*1=2 2*2=4 ... 2*9=18
3*1=3 3*2=6 ... 3*9=27
..

9*1=9 ......... 9*9=81
 -->
 
<c:forEach var="i" begin="2" end="9">
	${i }단
	<c:forEach var="j" begin="1" end="9">
		${i } * ${j } = ${i*j } &nbsp;
	</c:forEach>
	</br>
</c:forEach>


<%
	int[] arr={10,20,30,40,50};
	request.setAttribute("arr", arr);
%>
<h1>배열요소 출력</h1>
<!-- varStatus="s" : 배열의 상태값이 저장되어있음 -->
<c:forEach var="n" items="${requestScope.arr }" varStatus="s">
	${s.index } ==> ${n } <br>
</c:forEach>



</body>
</html>