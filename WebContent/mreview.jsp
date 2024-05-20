<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page import="com.dao.Dao"%>
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
<link href="style.css" rel="stylesheet" type="text/css" media="all" />
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
				<li><a href="hsearch.jsp" accesskey="2" title="">Hospital</a></li>
				<li class="active"><a href="uremedy.jsp" accesskey="3" title="">Remedy</a></li>
				<li><a href="Logout.jsp" accesskey="5" title="">Logout</a></li>
			</ul>
		</div>
	</div>
</div>
<div class="wrapper">
	<div id="welcome" class="container">
		<div class="title">
		<%
		session = request.getSession(false);
		String da = request.getParameter("da");
		String pid = request.getParameter("pid");
		String hid = request.getParameter("hid");
		String sql = "select medicine from umedicine where pid='"+pid+"' and date1='"+da+"'";
		String med = Dao.getName(sql);
		%>
			<h2>Medicine Feedback</h2>
			<form action="MReview" method="post">
			<table>
			<thead>
			<tr>
			<th>PID</th><th>HID</th><th>Medicine</th><th>Review</th><th>Rate</th><th>Post</th>
			</tr>
			</thead>
			<tbody>
			<tr>
			<td><input type="text" name="pid" value="<%=pid %>"/></td>
			<td><input type="text" name="hid" value="<%=hid %>"/></td>
			<td><input type="text" name="med" value="<%=med %>"/></td>
			<td><input type="text" name="rev"/></td>
			<td><input type="text" name="rate"/></td>
			<td><input type="submit" name="Rate"/></td>
			</tr>
			</tbody>
			</table>
			</form>
		</div>
	</div>
	<div id="three-column" class="container">
		<div><span class="arrow-down"></span></div>
		<div id="tbox1">
			<div class="title">
				
		
	</div>
</div>
<div id="footer">
	<div class="container">
		<div class="fbox1">
		<span class="icon icon-map-marker"></span>
			<
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
