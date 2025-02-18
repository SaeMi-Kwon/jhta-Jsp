<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2/2.jsp</title>
<script type="text/javascript">
	let xhr=null;
	function find(){
		const id=document.getElementById("id").value;  
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=getData;  //getData : 콜백이름, 이 부분의 이름은 아무거나해도 상관없다
		xhr.open("get", "findId.jsp?id=" + id, true);
		xhr.send();
	}
	function getData(){
		if(xhr.readyState==4){
			if(xhr.status!=200){
				alert("오류로 인해 서버와의 요청 실패");
			}else{
				//alert("success");
				const xml=xhr.responseXML;
				const div=document.getElementById("result");
				const code=xml.getElementsByTagName("code")[0].textContent;
				if(code=='success'){
					const pwd=xml.getElementsByTagName("pwd")[0].textContent;
					div.innerHTML="<h2>비밀번호:" + pwd + "</h2>";
				}else{
					div.innerHTML="<h2>해당 아이디가 존재하지 않습니다..</h2>";
				}
			}
		}
	}

</script>
</head>
<body>
	<h1>비밀번호 찾기</h1>
	아이디 <input type="text" name="id" id="id"><br>
	<input type="button" value="찾기" onclick="find()">
	<div id="result"></div>
</body>
</html>