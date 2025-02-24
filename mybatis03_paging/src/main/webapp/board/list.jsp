<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/list.jsp</title>
</head>
<body>
<!-- 검색창 -->
<form action="${pageContext.request.contextPath }/board/list" method="post">
	<select name="field">
		<%-- 조건문 : <c:if test="${field=='writer' }">selected</c:if> 선택 고정 --%>
		<option value="writer" <c:if test="${field=='writer' }">selected</c:if>>작성자</option>
		<option value="title" <c:if test="${field=='title' }">selected</c:if>>제목</option>
		<option value="content" <c:if test="${field=='content' }">selected</c:if>>내용</option>
	</select>
	<!-- 키워드입력한 값 고정 -->
	<input type="text" name="keyword" value="${keyword }"/>
	<input type="submit" value="검색" />
</form>

<a href="${pageContext.request.contextPath }/board/list">전체글보기</a> |
<a href="${pageContext.request.contextPath }/index.jsp">메인페이지</a>


<h1>글목록</h1>
<table border="1" width="500">
	<tr>
		<th>글번호</th><th>작성자</th><th>제목</th><th>내용</th><th>등록일</th>
	</tr>
	<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.num }</td>
			<td>${dto.writer }</td>
			<td>${dto.title }</td>
			<td>${dto.content }</td>
			<td>${dto.regdate }</td>
		</tr>
	</c:forEach>
</table>

<!-- 페이징 -->
<div>
	<!-- 이전페이지 -->
	<c:if test="${startPage>5}">
		<a href="${pageContext.request.contextPath }/board/list?pageNum=${startPage-1}">이전</a>
	</c:if>

	<c:forEach var="i" begin="${startPage }" end="${endPage }">
		<c:choose>
			<c:when test="${i==pageNum }"> <%-- 현재 페이지인 경우 빨간색 --%>
				<a href="${pageContext.request.contextPath }/board/list?pageNum=${i}&field=${field}&keyword=${keyword}">
					<span style="color:red;">[${i }]</span>
				</a>
			</c:when>
			<c:otherwise>  <%-- 현재 페이지인 아닌 경우 회색 --%>
				<a href="${pageContext.request.contextPath }/board/list?pageNum=${i}&field=${field}&keyword=${keyword}">
					<span style="color:gray;">[${i }]</span>
				</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<!-- 다음페이지 -->
	<c:if test="${endPage < pageCount}">
		<a href="${pageContext.request.contextPath }/board/list?pageNum=${endPage+1}">다음</a>
	</c:if>
</div>

</body>
</html>