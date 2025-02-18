<%@page import="org.json.JSONObject"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="db.JDBCUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    //join.jsp
    boolean exist=false;
	String id=request.getParameter("id");
	
	Connection con =JDBCUtil.getCon();
	PreparedStatement pstmt=con.prepareStatement("select * from myusers where id=?");
	pstmt.setString(1,id);
	ResultSet rs=pstmt.executeQuery();
	if(rs.next()){  
		exist=true;
	}
	JDBCUtil.close(con, pstmt, rs);
    

    //결과를 json로 응답하기
    response.setContentType("application/json; charset=UTF-8");
	PrintWriter pw=response.getWriter();
	
	JSONObject json=new JSONObject();
	json.put("exist",exist);

	pw.print(json.toString());
	pw.close();
%>