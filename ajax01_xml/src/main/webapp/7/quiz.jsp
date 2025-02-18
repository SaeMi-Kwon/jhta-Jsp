<%@page import="db.JDBCUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>6/quiz.jsp</title>
<style>
	#wrap{
        display: flex; 
        gap: 20px;       
    }

    #main{
    	display: flex;            
        flex-direction: column;
        gap: 20px;
    }

	#member{
		width: 200px;
        height: 50px;
		background-color: bisque;
		gap: 20px;
	}
	
	#info{
		display: none;
	}
</style>
<script>
    function getInfo(num){
        //const divs=document.getElementById("members");
        const info=document.getElementById("info");

        const xhr=new XMLHttpRequest();
        xhr.onreadystatechange=function(){
            if(xhr.readyState==4 && xhr.status==200){
                const xml=xhr.responseXML;
                const show=xml.getElementsByTagName("show")[0];
                const num1=show.getElementsByTagName("num")[0].textContent;
                const name=show.getElementsByTagName("name")[0].textContent;
                const phone=show.getElementsByTagName("phone")[0].textContent;
                const addr=show.getElementsByTagName("addr")[0].textContent;
                info.innerHTML="번호:"+ num1 + "<br> 이름:" + name + "<br> 주소:" + addr + "<br>전화번호:" +phone
                info.style.display = "block";
            }
        }

        xhr.open('get', 'detail.jsp?num='+ num, true);
        xhr.send();
    }
</script>
</head>
<body>
<h1>회원명단</h1>

<div id="wrap">
	<div id="main">
		<%
			Connection con=JDBCUtil.getCon();
			String sql="select num,name from members";
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()){
			    String num=rs.getString("num");
			    String name=rs.getString("name");
		
		%>
			<div id="member" onmouseover="getInfo('<%= num %>')">
				<%=num %> <%=name %>
			</div>
		<% 
			}
			JDBCUtil.close(con, pstmt, rs);
		%>		
	</div>
	
	<div id="info"></div>
</div>
</body>
</html>