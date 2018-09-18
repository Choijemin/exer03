<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MVC</title>
<link rel="stylesheet" href="<%=application.getContextPath()%>/css/style.css" />
</head>
<body>
	<div align="center">
		<h1># MVC #</h1>
		<div>
			<a href="<%=application.getContextPath() %>/login.do">회원 인증</a>
			| 
			<a href="<%=application.getContextPath() %>/join.do">회원 가입</a>
		</div>
	</div>
</body>
</html>