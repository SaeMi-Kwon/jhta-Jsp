<%@page import="java.util.ArrayList"%>
<%@page import="members.dto.MembersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>members/list.jsp</title>
</head>
<body>
<h1>회원목록</h1>
	<table border="1" width="500">
		<tr>
			<th>회원번호</th><th>이름</th><th>전화번호</th><th>주소</th><th>가입일</th>
			<th>삭제</th><th>수정</th>
		</tr>
<%
	ArrayList<MembersDto> list=(ArrayList<MembersDto>)request.getAttribute("list");
	for(MembersDto dto:list){
%>
	<tr>
		<td><%=dto.getNum() %></td>
		<td><%=dto.getName() %></td>
		<td><%=dto.getPhone() %></td>
		<td><%=dto.getAddr() %></td>
		<td><%=dto.getRegdate() %></td>
		<!-- 삭제기능 완성해 보세요. 삭제후 result.jsp페이지로 이동해서 결과 보여주기 -->
		<td><a href="/jsp06_members/members/delete?num=<%=dto.getNum() %>">삭제</a></td>
		<td><a href="/jsp06_members/members/update?num=<%=dto.getNum() %>">수정</a></td>
	</tr>
<%
	}
%>	
	</table>
	<a href="/jsp06_members/main.jsp">메인페이지</a>
</body>
</html>