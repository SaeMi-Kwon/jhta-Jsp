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
		//전체 댓글 출력하기
		function getList(pageNum){
			$.getJSON('${pageContext.request.contextPath}/comments/list',
				{"mnum":${dto.mnum},"pageNum": pageNum },
				function(data){
					//console.log(data);
						
					// 댓글 목록 초기화
					$("#commList").empty();
	                    
	                $(data.list).each(function(i,str){
						//console.log(str.id);
	                    const html="작성자:" + str.id + "<br>내용:" + str.comments + "<br>" +
	    				"<a href='javascript:delComm("+ pageNum + "," + str.num +")'>삭제</a>";
	                    	
	                    $("#commList").append("<div class='comlist'>"+html+"</div>");
	                    $(".comlist").addClass("comm");
					})
	                    
	                    
					// 페이징 처리
	    			let pagingHtml = "<div class='paging'>";
	    			// 이전 페이지 그룹
	    			if(data.startPage > 5){
	    				pagingHtml += "<a href='javascript:getList(" + (data.startPage - 1) + ")'>[이전]</a>";
	    			}
	    			// 페이지 번호 링크 생성
	    			for(let i = data.startPage; i <= data.endPage; i++){
	    				if(i === data.pageNum){
	    					pagingHtml += "<a href='javascript:getList(" + i + ")'><span style='color:red'>[" + i + "]</span></a>";
	    				}else{
	    						pagingHtml += "<a href='javascript:getList(" + i + ")'><span style='color:black'>[" + i + "]</span></a>";
	    				}
	    			}
	    			// 다음 페이지 그룹
	    			if(data.endPage < data.pageCount){
	    				pagingHtml += "<a href='javascript:getList(" + (data.endPage + 1) + ")'>[다음]</a>";
	    			}
	    			pagingHtml += "</div>";
	    				
	    			$("#commList").append(pagingHtml);
			});
	
		}
		getList(1);
				
		//댓글 추가기능
		$("#btnAdd").on('click',function(){
			const id=$("#id").val();
			const comments=$("#comments").val();
					
			$.getJSON('${pageContext.request.contextPath}/comments/insert',
				{"id": id, "comments": comments, "mnum":${dto.mnum} },
				function(json){
					if(json.result){
						getList(1);
					}else{
						alert("댓글 등록실패");
					}
			})
					
		});
				
		//댓글 삭제기능
		function delComm(page,num){
			$.getJSON('${pageContext.request.contextPath}/comments/delete', {"num": num }, function(json){
				if(json.result){
					getList(page);
				}else{
					alert("댓글 삭제실패");
				}
								
			})
					
		}						
	</script>

</body>
</html>