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
				<li><a href="mhome.jsp" accesskey="1" title="">Home</a></li>
				<li class="active"><a href="mdis.jsp" accesskey="2" title="">Diseases</a></li>
				<li><a href="asym.jsp" accesskey="3" title="">Add Medicine</a></li>
				<li><a href="logout.jsp" accesskey="4" title="">Logout</a></li>
			</ul>
		</div>
	</div>
</div>
<div class="wrapper">
	<div id="welcome" class="container">
		<div class="title">
			<%
		session = request.getSession(false);
		int id =  Integer.parseInt(request.getParameter("id"));
		String hid = request.getParameter("hid");
		String sql = "select symptoms from diseases where status1='Approved' and id="+id +" and hid='"+hid+"'";
		String sym = Dao.getName(sql);
		sql = "select disease from diseases where status1='Approved' and id="+id +" and hid='"+hid+"'";
		String dis = Dao.getName(sql);
		sql = "select agency from medical where email='"+session.getAttribute("uid")+"'";
		String agc = Dao.getName(sql);
		sql = "select Medicine from disease where disease='"+dis+"' and agency='"+agc+"'";
		System.out.println(sql);
		List<String> lt = Dao.getMedicine(sql);
		Iterator<String> itr = lt.iterator();
		%>
			<h2>Prescription</h2>
			<table>
			<thead>
			<tr><th>Id</th><th>HID</th><th>Symptoms</th><th>Prescription</th></tr>
			</thead>
			<%
			while(itr.hasNext()){
			%>
			<tbody>
			<tr><td><%=id %></td>
			<td><%=hid %></td>
			<td><% String med =itr.next(); %><%=med %></td>
			<td><a href="Prescription?id=<%=id%>&&med=<%=med %>" class="button alt">Prescription</a></td>
			</tr>
			</tbody>
			<%} %>
			</table>
		</div>
	</div>
	<div id="three-column" class="container">
		<div><span class="arrow-down"></span></div>
		<div id="tbox1">
			<div class="title">
				<h2>Maecenas luctus</h2>
			</div>
			
			
	</div>
</div>
<div id="footer">
	<div class="container">
		<div class="fbox1">
		
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
