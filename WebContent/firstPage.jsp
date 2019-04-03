<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/firstPage/css/firstPage.css" />
    <%@ include file="topLine.jsp" %>
	<title>研学旅行网站主页</title>
</head>
<body>
	<div>
		<label class="firstPage-title">研学旅行</label>
	</div>
	<div class="firstPage-top">
		<div class="firstPage-input-border" >
	      	<i class="Hui-iconfont Hui-iconfont-search2" ></i>
	       <span><input type="text" name="" id="searchKeyWord" placeholder="请输入学科搜索关键词" /></span>      
	    </div>
	    <button type="button" class="firstPage-btn" onclick="login();">搜索</button>    	
	</div>
	<div class="firstPage-firstHr" >
	 	<hr color=#0191d2 width="90%" size="2"/>
	</div>

	<div style="position: fixed;left: 80px;top: 180px; font-size: 50px;background:#84c1ff;width:10%;font-size:20px">
		<ul>
			<li style="display:block;"><a href="firstPage.jsp">主页</a></li>
			<li style="display:block;"><a href="#news">我的行程</a></li>
			<li style="display:block;"><a href="#contact">个人信息</a></li>
			<li style="display:block;"><a href="#about">About</a></li>
		</ul>	
	</div>
</body>
</html>