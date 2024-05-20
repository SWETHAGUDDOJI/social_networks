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
				<li><a href="chome.jsp" accesskey="1" title="">Home</a></li>
				<li class="active"><a href="hdis.jsp" accesskey="2" title="">Diseases</a></li>
				<li><a href="remedy.jsp" accesskey="3" title="">Remedies</a></li>
				<li><a href="index.html" accesskey="4" title="">Logout</a></li>
			</ul>
		</div>
	</div>
</div>
<div class="wrapper">
	<div id="welcome" class="container">
		<div class="title">
			<h2>Diseases</h2>
			<%
			String sql = "select * from diseases where status1='pending'";
		List<String> lt = Dao.getCDisease(sql);
		Iterator<String> itr = lt.iterator();
			%>
			<table>
			<thead>
			<tr><th>ID</th><th>HID</th><th>Encoded</th><th>Users</th><th>Disease</th><th>Symptoms</th><th>Send</th></tr>
			</thead>
			<%
			while(itr.hasNext()){
			%>
			<tbody>
			<tr><td><%=itr.next() %></td><td><%=itr.next() %></td>
			<td><%=itr.next() %></td><td><%=itr.next() %></td>
			<td><%=itr.next() %></td><td><%=itr.next() %></td>
			<td><a href="DSend?da=<%=itr.next() %>" class="button alt">Send</a></td></tr>
			</tbody>
			<%} %>
			</table>
		</div>
	</div>
	<div id="three-column" class="container">
		<div><span class="arrow-down"></span></div>
		<div id="tbox1">
			<li><a href="#" class="icon icon-twitter"><span>Twitter</span></a></li>
		<li><a href="#" class="icon icon-facebook"><span></span></a></li>
		<li><a href="#" class="icon icon-dribbble"><span>Pinterest</span></a></li>
		<li><a href="#" class="icon icon-tumblr"><span>Google+</span></a></li>
		<li><a href="#" class="icon icon-rss"><span>Pinterest</span></a></li>
	</ul>
</div>
</body>
</html>
