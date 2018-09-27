<%@page import="java.util.HashMap"%>
<%@page import="models.issueDao"%>
<%@page import="models.opinionDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MVC</title>
<c:url value="/css/style.css" var = "stylecss"/>
<link rel="stylesheet" href="${stylecss }" />
</head>
<body>
	<div align="center">
		<h1># MVC</h1>
		<div align="right" style="margin-right: 10%; margin-left: 10%; font-size: small;">
			<b>${sessionScope.id }</b>,  로그온 |
			<%-- <a href="<%=application.getContextPath() %>/logout.do">로그오프</a>  --%>
			<c:url value = "/logout.do" var = "logout"/>
			<a href="${logout }">로그오프</a> 
			<hr/>
		</div>
		<div style="margin-right: 10%; margin-left: 10%;">
			<c:url value = "/search.do" var = "search"/>
			<form action="${search }">
				<input type="text" style="width:98%;" placeholder="search keyword"/>
			</form>
		</div>
			<c:url value = "/trend.do" var = "trend"/>
			<c:url value = "/new.do" var = "newdo"/>
			<a href = "${trend }">이슈목록</a> |  
			<a href = "${newdo }">이슈등록</a>
		
			<div style="margin-right: 10%; margin-left: 10%;" align="left">
			<h3>가장 뜨거운 이슈</h3>
				<c:forEach var = "a" begin = "0" end = "${requestScope.hotsize }" step = "1">
				<div style="margin-bottom: 15px;" 
					onmouseenter="highlight(this, true);" onmouseleave="highlight(this, false)">
				<p style="text-align: right; color: gray; font-size: small;" >
					${sessionScope.hot[a].CATE } / 의견 : ${sessionScope.hot[a].COU } / ${af.format(sessionScope.hot[a].REGDATE) }	
				</p>
				<p>
				<c:url value = "/detail.do?no=${sessionScope.hot[a].NO }" var = "hotissues"/>
				 <a href="${hotissues }"><b>ISSUE.</b> ${sessionScope.hot[a].REP }</a>
				</p>
			</div>
			</c:forEach>
			<hr/>
		</div>
		
		<div style="margin-right: 10%; margin-left: 10%;" align="left">
			<h3>최근 등록된 새로운 이슈 !</h3>
			<c:choose>
				<c:when test="${requestScope.mainsize == 0 }">
				<ul>
					<li>24시간 이내에 등록된 이슈가 없습니다.</li>
				</ul>
				</c:when>
			</c:choose>
			
			<c:forEach var = "i" begin = "0" end = "${requestScope.mainsize }" step = "1">
		<%-- 	<c:forEach  var = "i" items = "${requestScope.mainsize }" > --%>
			<div style="margin-bottom: 15px;" 
					onmouseenter="highlight(this, true);" onmouseleave="highlight(this, false)">
				<p style="text-align: right; color: gray; font-size: small;" >
					${sessionScope.mi[i].CATE } / 작성자 :  ${sessionScope.mi[i].WRITER } /  ${df.format(sessionScope.mi[i].REGDATE) }
				</p>
				<c:url value = "/detail.do?no=${sessionScope.mi[i].NO } " var = "detaildo"/>
				<a href="${detaildo }"><b>ISSUE</b>. ${sessionScope.mi[i].REP }</a>
			</div>
			</c:forEach>
		</div>
		
		<div style="margin-right: 10%; margin-left: 10%;" align="left">
			<hr/>
			<h3>내가 참여한 이슈들</h3>
			<c:choose>
				<c:when test="${requestScope.mysize == 0 }">
					<ul>
						<li>내가 참여한 이슈가 없습니다</li>
					</ul>
				</c:when>
			</c:choose> 
			
 			<c:forEach var = "i" items = "${requestScope.mysize }">
				<c:choose>
					
				</c:choose>
			</c:forEach> 
		
		<%-- 	<%
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
		</div>  --%>
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