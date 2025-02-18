<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String n1=request.getParameter("n1");
	String n2=request.getParameter("n2");
	String op=request.getParameter("op");
	
	int num1= Integer.parseInt(n1);
	int num2= Integer.parseInt(n2);
	
	
	response.setContentType("text/xml;charset=utf-8");
	PrintWriter pw=response.getWriter();
	pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	
	pw.print("<result1>");
	if(op.equals("1")){
		pw.print("<code>" + num1 + "+" + num2 + "=" + (num1+num2) + "</code>");
	}else if(op.equals("2")){
		pw.print("<code>" + num1 + "-" + num2 + "=" + (num1-num2) + "</code>");
	}else if(op.equals("3")){
		pw.print("<code>" + num1 + "*" + num2 + "=" + (num1*num2) + "</code>");
	}else if(op.equals("4")){
		if(num2!=0){
			pw.print("<code>" + num1 + "/" + num2 + "=" + (num1/num2) + "</code>");
		}else{
			pw.print("<code> 0으로 나눌수없습니다.</code>");
		}
		
	}
	
	pw.print("</result1>");
	pw.close();
	
%>