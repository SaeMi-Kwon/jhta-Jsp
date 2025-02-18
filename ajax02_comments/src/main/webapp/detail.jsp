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
			<input type="button" value="등록" onclick="insertComm()">
		</div>		
	</div>

	<script>
		//전체 댓글 목록 ajax로 받아오기
		function commList(){
			const xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4 && xhr.status==200){
					//commList의 기존 댓글목록 지우기
					const commList=document.getElementById("commList");
					const children=commList.children;
					for(let i=children.length-1;i>=0;i--){
						commList.removeChild(children.item(i));
					}
					
					const xml=xhr.responseXML;
					//alert(xml);
					const comm=xml.getElementsByTagName("comm");
					
					//댓글목록들이 추가될 div
					if(comm.length!=0){
						for(let i=0;i<comm.length;i++){
							const num=comm[i].getElementsByTagName("num")[0].textContent;
							const mnum=comm[i].getElementsByTagName("mnum")[0].textContent;
							const id=comm[i].getElementsByTagName("id")[0].textContent;
							const comments=comm[i].getElementsByTagName("comments")[0].textContent;
							
							const div=document.createElement("div");
							div.innerHTML="아이디:" + id + "<br>" + "내용:" + comments + "<br>" +
							"<a href='javascript:delComm(" + num + ")'>삭제</a>";  //숫자타입 파라미터는 따옴표만 사용하면된다.
							div.className="comm";
							commList.appendChild(div);
						}
					}
					
				}
			}
			xhr.open('get','${pageContext.request.contextPath}/comments/list?mnum=${dto.mnum}',true);
			xhr.send();
		}
		commList();  //함수호출
		
		//댓글 삭제 처리
		function delComm(num){
			const xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4 && xhr.status==200){
					//alert("success");
					const xml=xhr.responseXML;
					const code=xml.getElementsByTagName("code")[0].textContent;
					if(code=='success'){
						commList();
					}else{
						alert("댓글 삭제 실패!");
					}
				}
			}
			const param="num=" + num
			xhr.open('post','${pageContext.request.contextPath}/comments/delete',true);
			xhr.setRequestHeader('Content-Type', "application/x-www-form-urlencoded");
			xhr.send(param);
		}
	
		//댓글 입력 처리
		function insertComm(){
			const xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4 && xhr.status==200){
					//alert("success");
					const xml=xhr.responseXML;
					const code=xml.getElementsByTagName("code")[0].textContent;
					if(code=='success'){
						commList();
					}else{
						alert("댓글 등록 실패!");
					}
				}
			};

			const id=document.getElementById("id").value;
			const comments=document.getElementById("comments").value;
			const param="id=" + id + "&comments=" + comments + "&mnum=${dto.mnum}";

			xhr.open('post','${pageContext.request.contextPath}/comments/insert',true);
			
			//post인 경우는 Content-Type을 설정해서 인코딩타입을 지정해야 함
			xhr.setRequestHeader('Content-Type', "application/x-www-form-urlencoded");
	
			xhr.send(param);  //url 넘겨주는건 send메소드에서 넘겨준다
		}

	</script>
</body>
</html>