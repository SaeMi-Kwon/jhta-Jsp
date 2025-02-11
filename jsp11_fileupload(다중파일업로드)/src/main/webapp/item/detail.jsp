<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>item/detail.jsp</title>
</head>
<body>
<h1>상세보기</h1>
<table border="1" width="500" >
	<tr>
		<td width="100">제품명</td>
		<td>${dto.itemname } </td>
	</tr>
	<tr>
		<td>가격</td>
		<td>${dto.price }원</td>
	</tr>
	<tr>
		<td>설명</td>
		<td>${dto.descrip }</td>
	</tr>
	<tr>
		<td>첨부파일</td>
		<td>
			<ul>
			<c:forEach var="f" items="${dto.files }">
				<li>${f.orgfilename } , ${f. filesize } bytes</li>
			</c:forEach>
			</ul>
		</td>
	</tr>
</table>
<a href="<%=request.getContextPath() %>/main.jsp">메인</a>

</body>
</html>