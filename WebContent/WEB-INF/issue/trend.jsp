<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MVC</title>
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/style.css" />
</head>
<body>
	<div align="center">
		<h1># MVC</h1>
		<div align="right"
			style="margin-right: 10%; margin-left: 10%; font-size: small;">
			<b><%= session.getAttribute("id") %></b>, 로그온 | <a
				href="<%=application.getContextPath()%>/logout.do">로그오프</a>
			<hr />
		</div>
		<h2>【토론목록】</h2>
		<div style="margin-right: 10%; margin-left: 10%; text-align: left">
			<div style="margin-bottom: 15px;" 
					onmouseenter="highlight(this, true);" onmouseleave="highlight(this, false)">
				<p style="text-align: right; color: gray; font-size: small;" >
					생활 / 1,211 의견 / 2018.09.18  
				</p>
				<p>
					<a href=""><b>ISSUE.</b> 10년을 기른 아이가 바뀐것을 알았다면?...</a>
				</p>
			</div>
			<div style="margin-bottom: 15px;"
				onmouseenter="highlight(this, true);" onmouseleave="highlight(this, false)">
				<p style="text-align: right; color: gray; font-size: small;" >
					정치 / 111 의견 / 2018.09.16   
				</p>
				<p>
					<a href=""><b>ISSUE.</b> 난 진보일까? 보수일까??</a>
				</p>
			</div>
		</div>
		<script>
			var highlight = function(t, e){
				if(e)
					t.style.background ="yellow";
				else
					t.style.background ="white";
			}
		
		
		</script>
	</div>
</body>
</html>