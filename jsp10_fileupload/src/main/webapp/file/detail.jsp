<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>file/detail.jsp</title>
</head>
<body>
<h1>파일정보</h1>
<table border="1" width="500" >
	<tr>
		<td width="100">파일번호</td>
		<td>${detail.filenum } </td>
	</tr>
	<tr>
		<td>작성자</td>
		<td>${detail.writer }</td>
	</tr>
	<tr>
		<td>제목</td>
		<td>${detail.title }</td>
	</tr>
	<tr>
		<td>파일명</td>
		<td>${detail.orgfilename }</td>
	</tr>	
	<tr>
		<td>내용</td>	
		<td>
			<div style="width:350px; height:200px;">
				${detail.content }
			</div>	
		</td>
	</tr>
	<tr>
		<td>이미지</td>
		<td>
			<img src="<%=request.getContextPath() %>/upload/${detail.savefilename }">
		</td>
	</tr>
	<tr>
		<td>파일크기</td>
		<fmt:formatNumber var="filesize" value="${detail.filesize }" pattern="###,###"/>
		<td>${filesize } bytes</td>
	</tr>
	
</table>

<a href="${pageContext.request.contextPath }/main.jsp">메인페이지</a>
</body>
</html>