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
	<div id="welcome" class="container">
		<div class="title">
		<%
		session = request.getSession(false);
		String hos = request.getParameter("hos");
		String sql = "select * from hospital where name like '%"+hos+"%'";
		List<String> lt = Dao.getRDisease(sql);
		Iterator<String> itr = lt.iterator();
		%>
			<h2>Hospital Details</h2>
			<table>
			<tr><th>HID</th><th>Hospital Name</th><th>Mobile</th><th>Location</th><th>Join</th></tr>
			<% while(itr.hasNext()){ 
				String hid = itr.next();
			%>
			<tr><td><a href="hfind.jsp?hid=<%=hid %>"><%=hid %></a></td><td><%=itr.next() %></td>
			<td><%=itr.next() %></td>
			<td><%=itr.next() %></td>
<td><a href="uhospital.jsp?hid=<%=hid %>" class="button alt">Join</a></td>
			</tr>
			<%} 
			
			%>
			</table>
		</div>
	</div>
	<div id="three-column" class="container">
		<div><span class="arrow-down"></span></div>
		<div id="tbox1">
			
	
		
	</div>
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