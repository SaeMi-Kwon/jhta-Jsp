<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>글 수정하기</h1>
	<form action="${pageContext.request.contextPath }/board/update" method="post">
	<%-- 
		<input type="hidden" name="num" value="${dto.num }">
		<input type="hidden" name="ref" value="${dto.ref }">
		<input type="hidden" name="lev" value="${dto.lev }">
		<input type="hidden" name="step" value="${dto.step }">
	--%>
		글번호<br>
		<input type="text" name="num" value="${dto.num }" readonly="readonly"><br>
		작성자<br>
		<input type="text" name="writer" value="${dto.writer }" readonly="readonly"><br>
		제목<br>
		<input type="text" name="title" value="${dto.title }"><br>
		내용<br>
		<textarea rows="5" cols="50" name="content">${dto.content }</textarea><br>
		<input type="submit" value="등록"><br>
	</form>
</body>
</html>