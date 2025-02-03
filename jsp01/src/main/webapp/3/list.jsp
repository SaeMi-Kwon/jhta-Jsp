<%@page import="java.sql.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="javax.naming.spi.DirStateFactory.Result"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
</head>
<body>
<table border="1" width="500">
	<tr>
		<th>회원번호</th><th>이름</th><th>전화번호</th><th>주소</th><th>가입일</th>
		<th>삭제</th><th>수정</th>
	</tr>
<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
		Class.forName("oracle.jdbc.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		con=DriverManager.getConnection(url,"c##scott","tiger");
		pstmt=con.prepareStatement("select * from members");
		rs=pstmt.executeQuery();
		while(rs.next()){
			int num=rs.getInt("num");
			String name=rs.getString("name");
			String phone=rs.getString("phone");
			String addr=rs.getString("addr");
			Date regdate=rs.getDate("regdate");
%>

<tr>
	<td><%=num %></td>
	<td><%=name %></td>
	<td><%=phone %></td>
	<td><%=addr %></td>
	<td><%=regdate %></td>
	<%-- <td><a href="delete.jsp?num=1&name=hong">삭제</a></td> --%>
	<td><a href="delete.jsp?num=<%=num %>">삭제</a></td>
	<td><a href="update.jsp?num=<%=num %>">수정</a></td>
</tr>

<%		
		}
		
	}catch(ClassNotFoundException ce){
		System.out.println(ce.getMessage());
		
	}finally{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) con.close();
	}

%>
</table>
</body>
</html>