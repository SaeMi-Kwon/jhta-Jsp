<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="db.JDBCUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//idcheck.jsp
	//파라미터값 아이디가 db존재하는지 검사
	boolean exist=false;
	String id=request.getParameter("id");
	Connection con =JDBCUtil.getCon();
	PreparedStatement pstmt=con.prepareStatement("select * from myusers where id=?");
	pstmt.setString(1,id);
	ResultSet rs=pstmt.executeQuery();
	if(rs.next()){  //해당아이디가 존재하면
		exist=true;
	}
	JDBCUtil.close(con, pstmt, rs);
	
	//결과를 xml로 응답하기
	response.setContentType("text/xml;charset=utf-8");
	PrintWriter pw =response.getWriter();
	pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	pw.print("<result>");
	pw.print("<exist>" + exist + "</exist>");
	pw.print("</result>");

%>