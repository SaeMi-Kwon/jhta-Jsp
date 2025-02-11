<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WEB-INF/views/layout.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/common.css">
</head>
<body>
	<div class="wrap">
		<div class="header">
			<jsp:include page="/WEB-INF/views/header.jsp"/>
		</div>
		<div class="content">
			<div style="padding:30px;">
				<jsp:include page="${content }"/>
			</div>
		</div>
		<div class="footer">
			<div style="padding:30px;">
				<jsp:include page="/WEB-INF/views/footer.jsp"/>
			</div>
		</div>
	</div>
</body>
</html>