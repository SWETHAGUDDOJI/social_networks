<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page import="java.util.Iterator"%>
<%@page import="com.dao.Dao"%>
<%@page import="java.util.List"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900|Quicksand:400,700|Questrial" rel="stylesheet" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />
<link href="main.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
<div id="header-wrapper">
	<div id="header" class="container">
		<div id="logo" style="padding-top: 2em; padding-bottom: .25em;">
			<h1 style="text-transform: uppercase; font-size: 2.5em;"><a href="#">Efficient Identity-Based Distributed Decryption Scheme for Electronic Personal Health Record Sharing System</a></h1>
		</div>
		<div id="menu">
			<ul>
				<li><a href="uhome.jsp" accesskey="1" title="">Home</a></li>
				<li class="active"><a href="hsearch.jsp" accesskey="2" title="">Hospital</a></li>
				<li><a href="uremedy.jsp" accesskey="3" title="">Remedy</a></li>
				<li><a href="logout.jsp" accesskey="5" title="">Logout</a></li>
			</ul>
		</div>
	</div>
</div>
<div class="wrapper">
	<div id="welcome" class="container" style="padding-top: 2em;">
		<div class="title">
		<%
		session = request.getSession(false);
		String hid = request.getParameter("hid");
		%>
			<h2>Join Hospital</h2>
			<form action="UReq" method="post">
			<table>
			<tr><td>Hospital</td><td><input type="text" name="hid" value="<%=hid %>"/></td></tr>
			<tr><td>Disease</td><td><input type="text" name="dis"/></td></tr>
			<tr><td>Symptoms</td><td><textarea rows="5" cols="30" name="sym"></textarea></td></tr>
			<tr><td><input type="submit" value="Send"/></td><td></td></tr>
			</table>
			</form>
		</div>
	</div>
	<div id="three-column" class="container">
		<div><span class="arrow-down"></span></div>
		<div id="tbox1">
			
		
</div>
<div id="footer">
	
</div>
<div id="copyright">
	<ul class="contact">
		<li><a href="#" class="icon icon-twitter"><span>Twitter</span></a></li>
		<li><a href="#" class="icon icon-facebook"><span></span></a></li>
		<li><a href="#" class="icon icon-dribbble"><span>Pinterest</span></a></li>
		<li><a href="#" class="icon icon-tumblr"><span>Google+</span></a></li>
		<li><a href="#" class="icon icon-rss"><span>Pinterest</span></a></li>
	</ul>
</div>
</body>
</html>
