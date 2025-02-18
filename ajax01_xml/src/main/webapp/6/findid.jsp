<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="db.JDBCUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String id="";
    String email=request.getParameter("email");
    String pwd=request.getParameter("pwd");

    Connection con=JDBCUtil.getCon();
    String sql="select RPAD(substr(id,1,3),length(id),'*') id "
    			+" from myusers where email=? and pwd=?";
    PreparedStatement pstmt=con.prepareStatement(sql);
    pstmt.setString(1,email);
    pstmt.setString(2,pwd);

    ResultSet rs=pstmt.executeQuery();
    if(rs.next()){
        id=rs.getString("id");
    }
    JDBCUtil.close(con, pstmt, rs);

    response.setContentType("text/xml;charset=utf-8");
    PrintWriter pw =response.getWriter();
	pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    pw.print("<find>");
    pw.print("<id>" + id + "</id>");
    pw.print("</find>");

%>