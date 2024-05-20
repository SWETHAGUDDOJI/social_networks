<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page import="com.dao.Encode"%>
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
				<li><a href="hhome.jsp" accesskey="1" title="">Home</a></li>
				<li><a href="papp.jsp" accesskey="2" title="">Patient</a></li>
				<li><a href="pdet.jsp" accesskey="3" title="">Patient Details</a></li>
				<li class="active"><a href="premedy.jsp" accesskey="4" title="">Remedy</a></li>
				<li><a href="medfeed.jsp" accesskey="5" title="">Feedback</a></li>
				<li><a href="logout.jsp" accesskey="6" title="">Logout</a></li>
			</ul>
		</div>
	</div>
</div>
<div class="wrapper">
	<div id="welcome" class="container">
		<div class="title">
			<%
		session = request.getSession(false);
		String sql = "select * from remedy where hid='"+session.getAttribute("uid")+"' and status1='Approved'";
		List<String> lt = Dao.getHMedicine(sql);
		String pid=request.getParameter("pid");
		Iterator<String> itr = lt.iterator();
		%>
			<h2>Remedy</h2>
			<table>
			<tr><th>ID</th>
		 <th>PID</th> 
			<th>Disease</th>
			<th>Symptom</th>
			<th>Medicine</th>
			<th>Date</th>
			<th>Send</th>
			</tr>
					<%
					while(itr.hasNext()){
						int id = Integer.parseInt(itr.next());
						sql = "select users from diseases where id="+id;
						String str = Dao.getName(sql);
						sql = "select key1 from diseases where id="+id;
						String key = Dao.getName(sql);
						String users = Encode.decode(str.trim(), key.trim());
					%>
					<tr>
					<td><%=id %></td>
					<td><%=pid %></td> 
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<td><%=itr.next() %></td>
					<% String da=itr.next(); %>
					<td> <%=da %></td>
					<td><a href="PSend?id=<%=pid %>&&da=<%=da %>" class="button alt">Send</a></td>
					</tr>
					<%} %>
			</table>
		</div>
	</div>
	<div id="three-column" class="container">
		<div><span class="arrow-down"></span></div>
		<div id="tbox1">
			<div class="title">
				
			

</div>
<div id="footer">
	<div class="container">
		<div class="fbox1">
		>
		<div class="fbox1">
			<span class="icon icon-envelope"></span>
		</div>
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
