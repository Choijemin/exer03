<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="models.issueDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	issueDao isd = new issueDao();
	List<Map> li = isd.allTrend();
	SimpleDateFormat df = new SimpleDateFormat("HH:mm");
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
			<hr />
		</div>
		<h2>【토론목록】</h2>
		<a href = "<%= application.getContextPath() %>/new.do">이슈 등록</a>
		<div style="margin-right: 10%; margin-left: 10%; text-align: left">
		<%
			for(int i = 0; i < li.size(); i++) {
				Map m = li.get(i);
		%>
			<div style="margin-bottom: 15px;" 
					onmouseenter="highlight(this, true);" onmouseleave="highlight(this, false)">
				<p style="text-align: right; color: gray; font-size: small;" >
					<%= m.get("CATE") %> / <%= m.get("WRITER") %> / <%= df.format(m.get("REGDATE")) %> 
				</p>
				<p>
					<a href=""><b>ISSUE.</b> <%= m.get("CONTENT") %></a>
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