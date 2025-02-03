<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update.jsp</title>
</head>
<body>
<%
	String num=request.getParameter("num");	

	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
		Class.forName("oracle.jdbc.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		con=DriverManager.getConnection(url,"c##scott","tiger");
		pstmt=con.prepareStatement("select * from members where num=?");
		pstmt.setString(1,num);
		rs=pstmt.executeQuery();
		
		if(rs.next()){
			String name=rs.getString("name");
			String phone=rs.getString("phone");
			String addr=rs.getString("addr");
			Date regdate=rs.getDate("regdate");
%>
	<h1>회원수정</h1>
	<!-- updateOk.jsp를 작성해 보세요.
		 전송된 정보를 회원정보를 수정후 결과출력하기(list.jsp페이지로 이동)
	-->
	<form action="updateOk.jsp" method="post">
	    <!-- disabled="disabled" : 수정을 못하고 서버로 데이터가 전송이 안됨
	    	 readonly="readonly" : 수정은 못하지만 데이터가 서버로는 전송됨
	    	 input type="hidden" : 화면에는 보이지 않지만 서버로 데이터가 전송됨
	    -->
	    <input type="hidden" name="num" value="<%=num %>"><br>
		회원번호 <input type="text" name="num" disabled="disabled" value="<%=num %>"><br>
		이름 <input type="text" name="name" value="<%=name %>"><br>
		전화번호 <input type="text" name="phone" value="<%=phone %>"><br>
		주소 <input type="text" name="addr" value="<%=addr %>"><br>
		가입일 <input type="text" name="regdate" disabled="disabled" value="<%=regdate %>"><br>
		<input type="submit" value="저장">
	</form>
	
<%
		}else{
			out.print("<h1>회원이 존재하지 않습니다.");
		}
	}catch(SQLException s){
		System.out.println(s.getMessage());
	}finally{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) con.close();
	}
		
%>
</body>
</html>