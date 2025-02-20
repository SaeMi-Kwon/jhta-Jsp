<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail.jsp</title>
<style>
	.comm{
		width: 400px;
		height: 100px;
		border: 1px solid #aaa;
		margin-bottom: 5px;
	}
</style>
</head>
<body>
	<div style="width:500px; height: 150px; background-color: pink">
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
		<div id="commAdd">
			아이디<br>
			<input type="text" id="id"><br>
			영화평<br>
			<textarea rows="3" cols="30" id="comments"></textarea><br>
			<input type="button" value="등록" id="btnAdd">
		</div>		
	</div>

	<script>
		//전체 댓글 출력하기(페이징처리)
		function getList(pageNum){
			const xhr=new XMLHttpRequest();
			xhr.onload=function(){
				
				const commList=document.getElementById("commList");

				//전 댓글 지우기
				const children=commList.children;
				for(let i=children.length-1;i>=0;i--){
					commList.removeChild(children.item(i));
				}

				const resp=xhr.responseText;
				const json=JSON.parse(resp);
			
				json.list.forEach(function(comm){
					const div=document.createElement("div");
					const str="작성자:" + comm.id + "<br>내용:" + comm.comments + "<br>" +
					"<a href='javascript:delComm("+ comm.num +")'>삭제</a>";
					div.innerHTML=str;
					div.className="comm";
					commList.appendChild(div);
				});

				
				//페이징처리
				let str="<div>";
				if(json.startPage>5){
					str += "<a href='javascript:getList(" + (json.startPage-1) + ")'>[이전]</a>";
				}

				for(let i=json.startPage;i<=json.endPage;i++){
					if(i==pageNum){
						str += "<a href='javascript:getList(" + i + ")'><span style='color:red'>[" + i + "]</span></a>";
					}else{
						str += "<a href='javascript:getList(" + i + ")'><span style='color:black'>[" + i + "]</span></a>";
					}
				}

				if(json.endPage<json.pageCount){
					str += "<a href='javascript:getList(" + (json.endPage+1) + ")'>[다음]</a>";
				}

				str += "</div>";
				commList.innerHTML += str;
			}
			xhr.open('get',
			'${pageContext.request.contextPath}/comments/list?mnum=${dto.mnum}&pageNum='+ pageNum,true);
			xhr.send();
		}
		getList(1);


		//ajax로 댓글 추가기능 구현하기(응답 - json)
		document.getElementById("btnAdd").addEventListener('click',function(){
			const id=document.getElementById("id").value;
			const comments=document.getElementById("comments").value;
			const xhr=new XMLHttpRequest();

			xhr.onload=function(){
				const resp=xhr.responseText;
				const json=JSON.parse(resp);
				const result=json.result;

				if(result){
					getList(1);
					//alert("댓글등록 성공!");
				}else{
					alert("댓글등록 실패!");
				}
			};
			
			const param="id=" + id + "&comments=" + comments + "&mnum=${dto.mnum}";
			xhr.open('post','${pageContext.request.contextPath}/comments/insert',true);
			xhr.setRequestHeader('Content-Type', "application/x-www-form-urlencoded");
			xhr.send(param);
		});
		
		function delComm(num){
			const xhr=new XMLHttpRequest();

			xhr.onload=function(){
				const resp=xhr.responseText;
				const json=JSON.parse(resp);
				const result=json.result;

				if(result){
					getList(1);
					//aleart("댓글삭제 성공");
				}else{
					aleart("댓글삭제 실패!");
				}
			};
			const param="num=" + num;
			xhr.open('post','${pageContext.request.contextPath}/comments/delete',true);
			xhr.setRequestHeader('Content-Type', "application/x-www-form-urlencoded");
			xhr.send(param);
		}

	</script>
</body>
</html>