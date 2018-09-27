<%@page import="java.util.HashMap"%>
<%@page import="models.issueDao"%>
<%@page import="models.opinionDao"%>
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
			<%
				opinionDao odo = new opinionDao();
				List<Map> hot = odo.hotissue();
				SimpleDateFormat af = new SimpleDateFormat("yyyy.MM.dd HH:mm");
				
			%>
			<h3>가장 뜨거운 이슈</h3>
			<%
				int hsu = 0;
				for(int i = 0; i < hot.size(); i++) {
					Map h = hot.get(i);
					String ctr = (String)h.get("CONTENT");
					if(ctr.contains("\n")) {
						h.put("REP", ctr.substring(0, ctr.indexOf("\n")));
					} else {
						h.put("REP", ctr);
					}
					hsu++;
			%>
				<div style="margin-bottom: 15px;" 
					onmouseenter="highlight(this, true);" onmouseleave="highlight(this, false)">
				<p style="text-align: right; color: gray; font-size: small;" >
		
					<%= h.get("CATE") %> / 의견 : <%= h.get("COUNT(*)") %> / <%= af.format(h.get("REGDATE")) %> 
		
				</p>
				<p>
				 <a href="<%= application.getContextPath() %>/detail.do?no=<%= h.get("NO") %>"><%= hsu %>.<b>ISSUE.</b> <%= h.get("REP") %></a>

				</p>
			</div>
			<% } %>
			<hr/>
		</div>
		
		<div style="margin-right: 10%; margin-left: 10%;" align="left">
			<h3>최근 등록된 새로운 이슈 !</h3>
			<% 
				List<Map> mi = (List)request.getAttribute("mi");
				SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm");
			%>
			<% if(mi.size() == 0) { %>
			<ul>
				<li>24 시간 이내 등록된 이슈가 없습니다</li>
			</ul>
			<% } %>
			<%
				int su = 0;
				for(int i = 0; i < mi.size(); i++) {
					Map z = mi.get(i);
					su++;	
			%>
			<div style="margin-bottom: 15px;" 
					onmouseenter="highlight(this, true);" onmouseleave="highlight(this, false)">
				<p style="text-align: right; color: gray; font-size: small;" >
		
					<%= z.get("CATE") %> / 작성자 : <%= z.get("WRITER") %> / <%= df.format(z.get("REGDATE")) %> 
		
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
			<%
				String talker = (String)session.getAttribute("id");
				List<Map> my = odo.myissue(talker);
				SimpleDateFormat mf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
			%>
			<% if(my.size() == 0) { %>
			<ul>
				<li>내가 참여한 이슈가 없습니다</li>
			</ul>
			<% } %>
			<%
				int msu = 0;
				for(int i = 0; i < my.size(); i++) {
					Map myi = my.get(i);
					String ctr = (String)myi.get("CONTENT");
					if(ctr.contains("\n")) {
						myi.put("REP", ctr.substring(0, ctr.indexOf("\n")));
					} else {
						myi.put("REP", ctr);
					}
					msu++;
					
			%>
			
			<div style="margin-bottom: 15px;" 
					onmouseenter="highlight(this, true);" onmouseleave="highlight(this, false)">
				<p style="text-align: right; color: gray; font-size: small;" >
		
					<%= myi.get("CATE") %> / <%= myi.get("WRITER") %> / <%= mf.format(myi.get("REGDATE")) %> 
		
				</p>
				<p>
				 <a href="<%= application.getContextPath() %>/detail.do?no=<%= myi.get("NO") %>"><%= msu %>.<b>ISSUE.<%= myi.get("REP") %></b> </a>

				</p>
			</div>
			<% } %>
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