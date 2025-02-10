<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>file/updateForm</title>
</head>
<body>
<h1>글 수정하기</h1>
<form action="<%=request.getContextPath() %>/file/update" 
		enctype="multipart/form-data" method="post">
	파일번호<br>
	<input type="text" name="filenum" value="${dto.filenum }" readonly="readonly"><br>
	작성자<br>
	<input type="text" name="writer" value="${dto.writer }" readonly="readonly"><br>
	제목<br> 
	<input type="text" name="title" value="${dto.title }"><br>
	내용<br>
	<textarea name="content" rows="5" cols="50">${dto.content }</textarea><br>
	첨부파일
	기존파일 : ${dto.orgfilename } <br>
	<input type="file" name="fileUpdate"><br>
	<input type="submit" value="전송">
</form>
</body>
</html>