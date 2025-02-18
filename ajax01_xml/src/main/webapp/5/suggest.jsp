<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%! //선언부 - service메소드에 코드가 삽입되는것이 아니라 멤버변수/멤버메소드 영역으로 코드가 삽입된다.
	//(메소드 정의할때나 지역변수가 아닌 멤버변수를 만들때 사용된다.)
	
	//http://localhost:8081/ajax01/5/suggest.jsp?find=a
	//http://localhost:8081/ajax01/5/suggest.jsp?find=자바
	
	String[] keyword={"Ajax","Ajax Programming","Ajax프로그래밍","자바","자바프로그래밍","아리랑"};
	
	public ArrayList<String> search(String find){
		if(find==null) return null;
		find=find.toUpperCase(); //검색키워드를 대문자로 변환 - 대소문자 구분없이 비교하기 위해
		ArrayList<String> list=new ArrayList<>();
		
		for(String s:keyword){
			if(s.toUpperCase().startsWith(find)){
				list.add(s);
			}
		}
		return list;
	}
	
%>

<% //스크립트릿 - jsp페이지가 서블릿으로 변환될때 service메소드 영역으로 코드가 삽입된다.
	String find=request.getParameter("find");
	ArrayList<String> list=search(find);
	
	StringBuffer sb=new StringBuffer();
	sb.append("<list>");
	
	for(String s:list){
		sb.append("<str>" + s + "</str>");
	}
	sb.append("</list>");
	
	//xml로 응답하기
	response.setContentType("text/xml;charset=utf-8");
	PrintWriter pw=response.getWriter();
	pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	pw.print(sb.toString());
	pw.close();
	
%>