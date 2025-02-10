<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>flie/list.jsp</title>
</head>
<body>
<h1>파일목록</h1>
<table border="1" width="800">
	<tr>
		<th>파일번호</th><th>작성자</th><th>제목</th><th>파일명</th><th>파일크기(bytes)</th>
		<th>상세보기</th><th>수정</th><th>삭제</th><th>이미지 다운로드</th>
	</tr>
<c:forEach var="dto" items="${list }">
	<tr>
		<td>${dto.filenum }</td>
		<td>${dto.writer }</td>
		<td>${dto.title }</td>
		<td>${dto.orgfilename }</td>
		<td>${dto.filesize } bytes</td>
		<td><a href="<%=request.getContextPath() %>/file/detail?filenum=${dto.filenum }">보기</a></td>
		<td><a href="<%=request.getContextPath() %>/file/update?filenum=${dto.filenum }">수정</a></td>
		<td><a href="<%=request.getContextPath() %>/file/delete?filenum=${dto.filenum }">삭제</a></td>
		<td><a href="<%=request.getContextPath() %>/file/download?filenum=${dto.filenum }">다운</a></td>
	</tr>
	</c:forEach>
</table>

<a href="${pageContext.request.contextPath }/main.jsp">메인페이지</a>

</body>
</html>