<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>item/insert.jsp</title>
</head>
<body>
	<h1>제품등록하기</h1>
	<form action="<%=request.getContextPath() %>/item/insert" 
			enctype="multipart/form-data"  method="post">
		상품명<br>
		<input type="text" name="itemname"><br>
		가격<br>
		<input type="number" name="price"><br>
		설명<br>
		<textarea name="descrip" rows="5" cols="50"></textarea><br>
		첨부파일
		<input type="file" name="file1" multiple="multiple"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>