<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- login.jsp -->
<div>
	<form action="<%=request.getContextPath() %>/login" method="post">
		아이디<input type="text" name="id"><br>
		비밀번호<input type="password" name="pwd"><br>
		<input type="submit" value="로그인">
	</form>
</div>
