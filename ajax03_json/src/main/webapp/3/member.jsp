<%@page import="org.json.JSONObject"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Date"%>
<%@page import="members.dto.MembersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	MembersDto dto=new MembersDto(1,"홍길동","010-111-1234","서울",new Date());

	//json으로 응답하기
	response.setContentType("text/plain;charset=utf-8");
	PrintWriter pw=response.getWriter();
	
	JSONObject json=new JSONObject();
	json.put("num",dto.getNum());
	json.put("name",dto.getName());
	json.put("phone",dto.getPhone());
	json.put("addr",dto.getAddr());
	json.put("regdate",dto.getRegdate());
	
	pw.print(json.toString());
	pw.close();

%>