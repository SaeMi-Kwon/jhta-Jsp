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
<h1>게시글 목록보기</h1>
<table border="1" width="500">
	<tr>
		<th>번호</th><th>작성자</th><th>제목</th>
		<th>상세보기</th><th>수정</th><th>삭제</th>
	</tr>
	<c:forEach var="dto" items="${list }">
	<tr>
		<td>${dto.filenum }</td>
		<td>${dto.writer }</td>
		<td>${dto.title }</td>
		<td><a href="${path }/board/detail?filenum=${dto.filenum }">보기</a></td>
		<td><a href="${path }/board/update?filenum=${dto.filenum }&writer=${sessionScope.id }">수정</a></td>
		<td><a href="${path }/board/delete?filenum=${dto.filenum }&writer=${sessionScope.id }">삭제</a></td>
	</tr>
	</c:forEach>
</table>

<!-- 페이징 -->
<div>
	<c:if test="${startPage>5 }">
		<a href="${path }/board/list?pageNum=${startPage-1}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage }" end="${endPage }">
		<c:choose>
			<c:when test="${i==pageNum }">
				<a href="${path }/board/list?pageNum=${i }">
					<span style="color:red;">[${i }]</span>
				</a>
			</c:when>
			<c:otherwise>
				<a href="${path }/board/list?pageNum=${i }">
					<span style="color:gray;">[${i }]</span>
				</a>
			</c:otherwise>
		</c:choose>	
	</c:forEach>
	
	<c:if test="${endPage < pageCount }">
		<a href="${path }/board/list?pageNum=${endPage+1}">[다음]</a>
	</c:if>
</div>




<a href="${path }/main.jsp">메인페이지</a>

</body>
</html>