<%@page import="java.io.PrintWriter"%>
<%@page import="db.JDBCUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    int num=Integer.parseInt(request.getParameter("num"));
	String name="";
    String phone="";
    String addr="";

    Connection con=JDBCUtil.getCon();
    String sql="select * from members where num=?";
    PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setInt(1,num);
    ResultSet rs=pstmt.executeQuery();

    if(rs.next()){
        name=rs.getString("name");
        phone=rs.getString("phone");
        addr=rs.getString("addr");
    }
   
    JDBCUtil.close(con, pstmt, rs);

    response.setContentType("text/xml;charset=utf-8");
    PrintWriter pw=response.getWriter();
    pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    pw.print("<show>");
    pw.print("<num>" + num + "</num>");
    pw.print("<name>" + name + "</name>");
    pw.print("<phone>" + phone + "</phone>");
    pw.print("<addr>" + addr + "</addr>");
    pw.print("</show>");
	pw.close();
%>