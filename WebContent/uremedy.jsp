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
				<li><a href="hsearch.jsp" accesskey="2" title="">Hospital</a></li>
				<li class="active"><a href="uremedy.jsp" accesskey="3" title="">Remedy</a></li>
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
		String sql = "select pid from udisease where userid='"+session.getAttribute("uid")+"'";
		List<String> lt = Dao.getMedicine(sql);
		Iterator<String> itr = lt.iterator();
		%>
			<h2>Medicine Details</h2>
			<table>
			<thead>
			<tr>
			<th>PID</th><th>HID</th><th>Disease</th><th>Medicine</th><th>Review</th>
			</tr>
			</thead>
			<%
			while(itr.hasNext()){
				String pid = itr.next();
				sql = "select * from umedicine where pid='"+pid+"'";
				List<String> lt1 = Dao.getPMedicine(sql);
				Iterator<String> itr1 = lt1.iterator();
				while(itr1.hasNext()){
					String pid1 = itr1.next();
					String hid = itr1.next();
			%>
			<tbody>
			<tr>
			<td><%=pid1 %></td>
			<td><a href="feedback.jsp?hid=<%=hid %>&&pid=<%=pid1 %>"><%=hid %></a></td>
			<td><%=itr1.next() %></td>
			<td><%=itr1.next() %></td>
			<td><a href="mreview.jsp?da=<%=itr1.next() %>&&hid=<%=hid %>&&pid=<%=pid %>" class="button alt">Review</a></td>
			</tr>
			</tbody>
			<%} 
			}%>
			</table>
		</div>
	</div>
	<div id="three-column" class="container">
		<div><span class="arrow-down"></span></div>
		<div id="tbox1">
			<div class="title">
				<h2>Maecenas luctus</h2>
			</div>
			<p>Nullam non wisi a sem semper eleifend. Donec mattis libero eget urna. Duis pretium velit ac suscipit mauris. Proin eu wisi suscipit nulla suscipit interdum.</p>
			<a href="#" class="button">Learn More</a> </div>
		<div id="tbox2">
			<div class="title">
				<h2>Integer gravida</h2>
			</div>
			<p>Proin eu wisi suscipit nulla suscipit interdum. Nullam non wisi a sem semper suscipit eleifend. Donec mattis libero eget urna. Duis  velit ac mauris.</p>
			<a href="#" class="button">Learn More</a> </div>
		<div id="tbox3">
			<div class="title">
				<h2>Praesent mauris</h2>
			</div>
			<p>Donec mattis libero eget urna. Duis pretium velit ac mauris. Proin eu wisi suscipit nulla suscipit interdum. Nullam non wisi a sem suscipit  eleifend.</p>
			<a href="#" class="button">Learn More</a> </div>
	</div>
	<div id="portfolio" class="container">
		<div class="column1">
			<div class="box"> <a href="#"><img src="images/scr01.jpg" alt="" class="image image-full" /></a>
				<h3>Vestibulum venenatis</h3>
				<p>Fermentum nibh augue praesent a lacus at urna congue rutrum.</p>
				<a href="#" class="button button-small">Etiam posuere</a> </div>
		</div>
		<div class="column2">
			<div class="box"> <a href="#"><img src="images/scr02.jpg" alt="" class="image image-full" /></a>
				<h3>Praesent scelerisque</h3>
				<p>Vivamus fermentum nibh in augue praesent urna congue rutrum.</p>
				<a href="#" class="button button-small">Etiam posuere</a> </div>
		</div>
		<div class="column3">
			<div class="box"> <a href="#"><img src="images/scr03.jpg" alt="" class="image image-full" /></a>
				<h3>Donec dictum metus</h3>
				<p>Vivamus fermentum nibh in augue praesent urna congue rutrum.</p>
				<a href="#" class="button button-small">Etiam posuere</a> </div>
		</div>
		<div class="column4">
			<div class="box"> <a href="#"><img src="images/scr04.jpg" alt="" class="image image-full" /></a>
				<h3>Mauris vulputate dolor</h3>
				<p>Rutrum fermentum nibh in augue praesent urna congue rutrum.</p>
				<a href="#" class="button button-small">Etiam posuere</a> </div>
		</div>
	</div>
</div>
<div id="footer">
	<div class="container">
		<div class="fbox1">
		<span class="icon icon-map-marker"></span>
			<span>1234 Fictional Road Suite #789
			<br />Nashville TN 00000</span>
		</div>
		<div class="fbox1">
			<span class="icon icon-phone"></span>
			<span>
				Telephone: +1 800 123 4657
			</span>
		</div>
		<div class="fbox1">
			<span class="icon icon-envelope"></span>
			<span>businessname@business.com</span>
		</div>
	</div>
</div>
<div id="copyright">
	<p>&copy; Untitled. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>.</p>
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
