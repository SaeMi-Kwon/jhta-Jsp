<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/mypage.jsp</title>
</head>
<body>
<h1>마이페이지</h1>
<form action="${path }/member/mypage" method="post">
	아이디 <input type="text" name="id" disabled="disabled" value=${dto.id }><br>
	비밀번호 <input type="password" name="pwd" value=${dto.pwd }><br>
	이메일 <input type="email" name="email" value=${dto.email }><br>
	등록일 <input type="text" name="regdate" disabled="disabled" value=${dto.regdate }><br>
	<input type="submit" value="수정">
	<input type="submit" value="탈퇴" formaction="${path }/member/delete">
</form>
<a href="${path }/main.jsp">메인</a>
</body>
</html>