<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>file/insert.jsp</title>
</head>
<body>
<h1>글등록하기</h1>
<!-- 
	<파일업로드시 form에 아래 속성을 꼭 설정해야 함>
	method="post"
	enctype="multipart/form-data"  
	-> 인코딩방식 [기본값:application/x-www-form-urlencoded] <- 폼데이터형식
 -->

<form action="<%=request.getContextPath() %>/file/upload" 
		enctype="multipart/form-data" method="post">
	작성자<br>
	<input type="text" name="writer"><br>
	제목<br> 
	<input type="text" name="title"><br>
	내용<br>
	<textarea name="content" rows="5" cols="50"></textarea><br>
	첨부파일
	<input type="file" name="file1"><br>
	<input type="submit" value="전송">
</form>

</body>
</html>