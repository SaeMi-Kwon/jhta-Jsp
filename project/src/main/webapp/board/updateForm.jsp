<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/updateForm.jsp</title>
</head>
<body>
<h1>게시글수정</h1>
<form action="${path }/board/update" method="post" enctype="multipart/form-data">
	파일번호<br>
	<input type="text" name="filenum" value="${dto.filenum }" readonly="readonly"><br>
	작성자 <br>
	<input type="text" name="id" value=${sessionScope.id } disabled="disabled"><br>
	제목 <br>	
	<input type="text" name="title" value=${dto.title }><br>
	내용 <br>
	<textarea name="content"  rows="5" cols="50">${dto.content }</textarea><br>
	기존파일 : ${dto.orgfilename } <br>
	첨부파일
	<input type="file" name="fu"><br>
	<input type="submit" value="수정">
</form>
</body>
</html>