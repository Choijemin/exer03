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
			<b>blahblah</b>, 로그온 | <a
				href="<%=application.getContextPath()%>/logout.do">로그오프</a>
			<hr />
		</div>
		<h2>【토론배틀】</h2>
		<small style="font-style: italic;">찬성이냐, 반대냐 그것이 문제로다!</small>
		<div style="margin-right: 10%; margin-left: 10%; text-align: left;">
			<h3>#. 안락사 옳은정책인가</h3>
			<p>
				안락사 옳은 정책인가<br/>
				무거운 주제이지만 한번 쯤은 고민해볼 문제인것 같습니다.<br/><br/>
				과연 안락사는 옳은 행위입니까?
			</p>
		</div>
		<div style="margin-right: 10%; margin-left: 10%; text-align: left; margin-top: 	55px; font-size: small;">
			<p style="color: blue">
				<b>YES</b> 안락사를 허용해야 한다. <span>221</span> 명 
			</p>
			<p style="color: red">
				<b>NO</b> 안락사를 허용해서는 안된다. <span>721</span> 명 
			</p>
		</div>
		
		<div style="margin-right: 10%; margin-left: 10%; text-align: left; margin-top: 	55px;">
			<p>
			<b>〔의견남기기〕</b><br/>
			</p>
			<p>
			<select>
				<option value="1">YES</option>
				<option value="0">NO</option>
			</select>
			<input type="text" style="width: 80%"/>
			</p>
		</div>
		
		<div style="margin-right: 10%; margin-left: 10%; text-align: left; margin-top: 	35px;">
			<p>
				<b>〔전체의견 / <span>942건</span>〕</b><br/>
			</p>
			<ul style="list-style: none; font-size: smaller;">
				<li><b style="color:blue">YES</b> 우리나라의 소극적 안락사 정도는 필요하다고 생각한다</li>
				<li><b style="color:blue">YES</b> 삶이 죽음보다 더 큰 고통인 사람들이 많습니다</li>
				<li><b style="color:red">NO</b> 인위적으로 사람을 죽이는 일이 허용되야 합니까?</li>
			</ul>
		</div>
	</div>
</body>
</html>