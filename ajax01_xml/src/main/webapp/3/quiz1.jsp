<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3/quiz1.jsp</title>

<script type="text/javascript">
	let xhr=null;
	function getResult(){
		const n1=document.getElementById("num1").value;
		const n2=document.getElementById("num2").value;
		const op=document.getElementById("oper").value;
		xhr=new XMLHttpRequest();
		xhr.onreadystatechange=callback;
		xhr.open("get","calc.jsp?n1="+n1+"&op="+ op + "&n2="+n2,true);
		xhr.send();
	}

	function callback(){
		if(xhr.readyState==4 && xhr.status==200){
			var data=xhr.responseXML;
			var num1=data.getElementByTagName("num1")[0].firstChild.nodeValue;
			var num2=data.getElementByTagName("num2")[0].firstChild.nodeValue;
			var num3=data.getElementByTagName("num3")[0].firstChild.nodeValue;
			
		}
	}

</script>
</head>
<body>
<p>두 정수를 입력후 계산 버튼을 누르면 ajax를 사용해서 두수합을 div#result에 출력되도록 해보세요.</p>
<input type="text" id="num1" size="10">
<select id="oper">
	<option value="1">+</option>
	<option value="2">-</option>
	<option value="3">*</option>
	<option value="4">/</option>
</select>
<input type="text" id="num2" size="10">

<input type="button" value="계산" onclick="getResult()">
<div id="result"></div>
</body>
</html>