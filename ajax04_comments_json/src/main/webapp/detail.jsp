<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail.jsp(jqueryAjax)</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>   
</head>
<body>
	<div style="width:500px; height:150px; background-color: pink">
		<h1>${dto.title }</h1>
		<ul>
			<li>내용: ${dto.content }</li>
			<li>감독: ${dto.director }</li>
		</ul>
	</div>
	<br>
	
	<div>
		<!-- 댓글목록이 보여질 div -->
		<div id="commList"></div>
		
		<!-- 댓글 입력 -->
		<div id="commAdd">
			아이디<br>
			<input type="text" id="id"><br>
			영화평<br>
			<textarea rows="3" cols="30" id="comments"></textarea><br>
			<input type="button" value="등록" id="btnAdd">
		</div>		
	</div>
	
	<script>

			$(function(){
				function gitList(pageNum){
					$.getJSON('${pageContext.request.contextPath}/comments/list',{"mnum":${dto.mnum},"pageNum": pageNum },function(data){
	                    //console.log(data);
	                    $(data.list).each(function(i,str){
	                    	console.log(str.id);
	                    	const html="작성자:"+ ${str.id}+"<br>내용:"+ ${str.comments}+"<br>";
	                    	$("#commList").append("<div>"+html+"</div>");
	                    })
	                })
				}
				gitList(1);
			});	
	
	</script>

</body>
</html>