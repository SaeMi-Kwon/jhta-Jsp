<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1/main.jsp</title>
</head>
<body>
<jsp:include page="sample.jsp"/> <!-- 페이지 삽입하기(출력결과 페이지가 삽입된다) -->
<div>main.jsp페이지입니다..</div>
<%--
	out.print("name:" + name);  //에러
--%>
<p>이번 대책은 산림 내 무속 행위, 달집태우기 등으로 인한 산불 피해를 최소화하기 위해 마련됐다.</p>
</body>
</html>