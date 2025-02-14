<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/insertForm.jsp</title>
</head>
<body>
<h1>게시글작성</h1>
<form action="${path }/board/insert" method="post" enctype="multipart/form-data">
	작성자 <br>
	<input type="text" name="id" value=${sessionScope.id } disabled="disabled"><br>
	제목 <br>	
	<input type="text" name="title"><br>
	내용 <br>
	<textarea name="content"  rows="5" cols="50"></textarea><br>
	첨부파일 <input type="file" name="f"><br>
	<input type="submit" value="전송">
</form>
</body>
</html>