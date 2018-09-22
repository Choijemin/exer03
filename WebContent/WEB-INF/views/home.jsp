<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
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
		<h1># MVC</h1>
		<div align="right" style="margin-right: 10%; margin-left: 10%; font-size: small;">
			<b><%= session.getAttribute("id") %></b>,  로그온 |
			<a href="<%=application.getContextPath() %>/logout.do">로그오프</a>
			<hr/>
		</div>
		<div style="margin-right: 10%; margin-left: 10%;">
			<form action="<%=application.getContextPath() %>/search.do">
				<input type="text" style="width:98%;" placeholder="search keyword"/>
			</form>
		</div>
			<a href = "<%= application.getContextPath() %>/trend.do">이슈목록</a> |  
			<a href = "<%= application.getContextPath() %>/new.do">이슈등록</a>
		
			<div style="margin-right: 10%; margin-left: 10%;" align="left">
			<h3>가장 뜨거운 이슈</h3>
			<ul>
				<li>10년을 키운 아이가 내 아이가 아니다.</li>
			</ul>
		</div>
		<div style="margin-right: 10%; margin-left: 10%;" align="left">
			<h3>최근 등록된 새로운 이슈 !</h3>
			<% 
				List<Map> mi = (List)request.getAttribute("mi");
				SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm");
			%>
			<%
				int su = 0;
				for(int i = 0; i < mi.size(); i++) {
					Map z = mi.get(i);	
					su++;
			%>
			<div style="margin-bottom: 15px;" 
					onmouseenter="highlight(this, true);" onmouseleave="highlight(this, false)">
				<p style="text-align: right; color: gray; font-size: small;" >
		
					<%= z.get("NO") %>. <%= z.get("CATE") %> / <%= z.get("WRITER") %> / <%= df.format(z.get("REGDATE")) %> 
		
				</p>
				<p>
				 <a href="<%= application.getContextPath() %>/detail.do?no=<%= z.get("NO") %>"><%= su %>.<b>ISSUE.</b> <%= z.get("REP") %></a>

				</p>
			</div>
			<% } %>
		</div>
		<div style="margin-right: 10%; margin-left: 10%;" align="left">
			<hr/>
			<h3>내가 참여한 이슈들</h3>
			<ul>
				<li>24 시간 이내 등록된 이슈가 없습니다</li>
			</ul>
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