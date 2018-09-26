<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="models.issueDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	
	List<Map> list = (List)request.getAttribute("li");
	SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm");
%>
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
			<hr/>
			<a href = "<%= application.getContextPath() %>/new.do">이슈 등록</a>  |
			<a href = "<%= application.getContextPath() %>/index.do">홈으로</a>
		</div>
		<h2>【토론목록】</h2>
		<div align="center" style="margin-right: 10%; margin-left: 10%; font-size: small;">
		전체(3) <br>
		<a href="<%=application.getContextPath()%>/cate.do?cate=it">IT/컴퓨터(1)</a>
		| <a href="<%=application.getContextPath()%>/cate.do?cate=game">게임(1)</a>
		| <a href="<%=application.getContextPath()%>/cate.do?cate=politics">정치/경제(1)</a>
		| <a href="<%=application.getContextPath()%>/cate.do?cate=sports">운동(1)</a><br>
	    <a href="<%=application.getContextPath()%>/cate.do?cate=food">요리/음식(1)</a>
		| <a href="<%=application.getContextPath()%>/cate.do?cate=movie">영화/문화(1)</a>
		| <a href="<%=application.getContextPath()%>/cate.do?cate=life">생활(1)</a>
		| <a href="<%=application.getContextPath()%>/cate.do?cate=etc">기타(1)</a>
		
		</div>
		<div style="margin-right: 10%; margin-left: 10%; text-align: left">
		<%
			for(int i = 0; i < list.size(); i++) {
				Map m = list.get(i);
		%>
			<div style="margin-bottom: 15px;" 
					onmouseenter="highlight(this, true);" onmouseleave="highlight(this, false)">
				<p style="text-align: right; color: gray; font-size: small;" >
					<%= m.get("NO") %>.<%= m.get("CATE") %> / 의견 : <%= m.get("COUNT(*)") %> / <%= df.format(m.get("REGDATE")) %> 
				</p>
				<p>
					
					<a href="<%= application.getContextPath() %>/detail.do?no=<%= m.get("NO") %>"><b>ISSUE.</b> <%= m.get("REP") %></a>
				</p>
			</div>
		<% } %>
		
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