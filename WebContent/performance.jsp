<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page import="java.util.Iterator"%>
<%@page import="com.dao.Dao"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.google.gson.Gson"%>
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
				<li><a href="ahome.jsp" accesskey="1" title="">Home</a></li>
				<li><a href="ahdet.jsp" accesskey="2" title="">Hospitals</a></li>
				<li><a href="amdet.jsp" accesskey="3" title="">Researchers</a></li>
				<li><a href="auser.jsp" accesskey="4" title="">Users</a></li>
				<li class="active"><a href="performance.jsp" accesskey="5" title="">HPerformance</a></li>
				<li><a href="mperformance.jsp" accesskey="6" title="">MPerformance</a></li>
				<li><a href="index.html" accesskey="7" title="">Logout</a></li>
			</ul>
		</div>
	</div>
</div>
<div class="wrapper">
	<div id="welcome" class="container">
		<div class="title">
			<%
Gson gsonObj = new Gson();
Map<Object,Object> map = null;
List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
String sql = "select hid from hospital";
List<String> lt = Dao.getMedicine(sql);
Iterator<String> itr = lt.iterator();
while(itr.hasNext()){
	String hid = itr.next();
	sql = "select count(*) from hreview where hid='"+hid+"'";
	int hcount = Dao.getCount(sql);
	sql = "select SUM(rating) FROM hreview WHERE hid='"+hid+"'";
	int  rcount = Dao.getCount(sql);
	if(rcount == 0 ){
		rcount = 1;
	}
	if(hcount == 0){
		hcount = 1;
	}
	rcount = rcount / hcount;
	map = new HashMap<Object,Object>(); map.put("label", hid); map.put("y", rcount); list.add(map);
}

 
String dataPoints = gsonObj.toJson(list);
%>
 
<script type="text/javascript">
window.onload = function() { 
 
var chart = new CanvasJS.Chart("chartContainer", {
	theme: "light2",
	title: {
		text: "Hospital Rating"
	},
	axisX: {
		title: "No of Users"
	},
	axisY: {
		title: "Rating"
	},
	data: [{
		type: "line",
		yValueFormatString: "#,##0 rating",
		dataPoints : <%out.print(dataPoints);%>
	}]
});
chart.render();
 
}
</script>
<div id="chartContainer" style="height: 370px; width: 100%; "></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
		</div>
	copyright">
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