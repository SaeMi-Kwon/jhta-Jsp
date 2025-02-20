<%@page import="java.util.Date"%>
<%@page import="members.dto.MembersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	MembersDto dto=new MembersDto(1,"홍길동","010-111-1234","서울",new Date());

%>

<h1>회원번호:<%=dto.getNum() %></h1>
<ul>
	<li>회원이름 : <%=dto.getName() %></li>
	<li>전화번호 : <%=dto.getPhone() %></li>
	<li>주소 : <%=dto.getAddr() %></li>
	<li>가입날짜 : <%=dto.getRegdate() %></li>
</ul>
<img src="../images/1.png">