<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Date"%>
<%@page import="members.dto.MembersDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 
	//json을 객체로 담기위한 객체(예시)
	JSONArray arr1=new JSONArray();
	JSONObject obj=new JSONObject();
	obj.put("id","hello");
	obj.put("pwd","1234");
	
	JSONObject obj1=new JSONObject();
	obj1.put("id","admin");
	obj1.put("pwd","1111");
	arr1.put(obj);
	arr1.put(obj1);

 --%>


<%
	ArrayList<MembersDto> list=new ArrayList<>();
	list.add(new MembersDto(1,"홍길동","010-222-333","서울",new Date()));
	list.add(new MembersDto(2,"김길동","010-444-333","대구",new Date()));
	list.add(new MembersDto(3,"이길동","010-555-333","부산",new Date()));

	//json을 객체로 담기위한 객체
	JSONArray arr=new JSONArray(list);  //list를 json객체 배열로 만들기
	JSONObject data=new JSONObject();  //json으로 응답하기 위한 객체
	data.put("list",arr);
	response.setContentType("text/plain;charset=utf-8");
	PrintWriter pw=response.getWriter();
	//pw.print(arr);
	pw.print(data);
	pw.close();
%>