<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/list.jsp</title>
</head>
<body>
	
<c:set var="cp" value="${pageContext.request.contextPath }"/>

<!-- 게시글 내용 테이블  -->
<h1>게시글 목록</h1>
<table border="1" width="500">
		<tr>
			<th>글번호</th><th>작성자</th><th>제목</th>
			<th>수정</th><th>삭제</th>
		</tr>
	<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.num }</td>
			<td>${dto.writer }</td>
			<td>
				<c:if test="${dto.lev>0 }"> <%-- 답글인 경우 --%>
					<c:forEach var="i" begin="1" end="${dto.lev }">
						&nbsp;&nbsp;
					</c:forEach>
					[re]
				</c:if>
			
				<a href="${cp }/board/detail?num=${dto.num}">${dto.title }</a>
			</td>	
		</tr>
	</c:forEach>
</table>

<!-- 페이징처리 -->

<div>
	<!-- 이전 -->
	<c:choose>
		<c:when test="${startPage>10 }">
				<a href="${cp }/board/list.do?pageNum=${startPage-1 }">[이전]</a>
		</c:when>
		<c:otherwise>
				[이전]
		</c:otherwise>
	</c:choose>


	<c:forEach var="i" begin="${startPage }" end="${endPage }">
		<c:choose>
			<c:when test="${pageNum==i }"><%-- 현재 페이지인 경우 색 다르게 나타내기 --%>
				<a href="${cp }/board/list?pageNum=${i}">
					<span style="color:red">${i }</span>		
				</a>
			</c:when>
			<c:otherwise>
				<a href="${cp }/board/list?pageNum=${i}">
					<span style="color:gray">${i }</span>
				</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<!-- 다음 -->
	<c:choose>
		<c:when test="${endPage<pageCount }">
			<a href="${cp }/board/list.do?pageNum=${endPage+1 }">[다음]</a>
		</c:when>
		<c:otherwise>
			[다음]
		</c:otherwise>
	</c:choose>
	
</div>
	
<a href="${pageContext.request.contextPath }/main.jsp">메인페이지</a>

</body>
</html>