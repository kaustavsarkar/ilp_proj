<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.tcs.ilp.POJO.Order,com.tcs.ilp.POJO.Outlet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ABC Online Retail Store</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<%-- <script src="<%=request.getContextPath() %>/JS/jquery.min.js"></script> --%>
<script src="<%=request.getContextPath() %>/JS/jquery.dropotron.min.js"></script>
<script src="<%=request.getContextPath() %>/JS/jquery.scrolly.min.js"></script>
<script src="<%=request.getContextPath() %>/JS/jquery.scrollgress.min.js"></script>
<script src="<%=request.getContextPath() %>/JS/skel.min.js"></script>
<script src="<%=request.getContextPath() %>/JS/skel-layers.min.js"></script>
<script src="<%=request.getContextPath() %>/JS/init.js"></script>

<link rel="stylesheet" href="<%=request.getContextPath() %>/CSS/skel.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/CSS/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/CSS/style-wide.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/CSS/style-noscript.css" />

<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
</head>
<body class="index"  >



<!-- Header -->
<header id="header" class="alt">
<h1 id="logo"><a >ABC Company <span>Retail</span></a></h1>
<nav id="nav">
<ul><%String name=null; 
int a=0;
if(request.getSession(false)!=null ){name=(String)session.getAttribute("name"); 
			a=Integer.parseInt(session.getAttribute("Id").toString());}%>
<%
if(request.getSession(false)!=null  && name!=null){ %>

	<li class="current"><a href="<%=request.getContextPath()%>/JSP/home.jsp">Welcome &nbsp <%=name %></a></li>
	<li class="submenu"><a href="">Departments</a>
	<%}else{ %>
	<li class="current"><a href="<%=request.getContextPath()%>/JSP/welcome.jsp">Welcome</a></li>
	<li class="submenu"><a href="">Departments</a>
	<%} %>
	<ul>
		<li><a href="<%=request.getContextPath() %>/CustomerController?name=Cosmetics&action=getitems&ID=<%if(a!=0){%><%=a%><%}%>">Cosmetics</a></li>
		<li><a href="<%=request.getContextPath() %>/CustomerController?name=bakery&action=getitems&ID=<%if(a!=0){%><%=a%><%}%>">Bakery</a></li>
		<li><a href="<%=request.getContextPath() %>/CustomerController?name=dairy&action=getitems&ID=<%if(a!=0){%><%=a%><%}%>">Dairy</a></li>
		<li><a href="<%=request.getContextPath() %>/CustomerController?name=deli&action=getitems&ID=<%if(a!=0){%><%=a%><%}%>">Deli Products</a></li>
		<li><a href="<%=request.getContextPath() %>/CustomerController?name=daily consumables&action=getitems&ID=<%if(a!=0){%><%=a%><%}%>">Daily Consumables</a></li>
		<li><a href="<%=request.getContextPath() %>/CustomerController?name=seafood&action=getitems&ID=<%if(a!=0){%><%=a%><%}%>">Sea Food</a></li>

		<li class="submenu"><a href="">New In Store</a>
		<ul>
			<li><a href="#">Chocolates</a></li>
			<li><a href="#">Kids Section</a></li>
			<li><a href="#">Fruits Section</a></li>
			<li><a href="#">20% Discount on dairy product</a></li>

		</ul>
		</li>
	</ul>
	</li>
	<li><a href="<%=request.getContextPath() %>/CustomerController?name=Cosmetics&action=CartViewer&customerId=<%=a %>" class="button special">Cart </a></li>
	<%if(request.getSession(false)!= null && name!=null) 
	{
	%>
	
	<li><a href="<%=request.getContextPath() %>/CustomerController?action=viewUrProfile" class="button special">View Profile </a></li>
	<%-- <li><a href="<%=request.getContextPath() %>/CustomerController?action=vieworders" class="button special">Orders </a></li> --%>
	<li><a href="<%=request.getContextPath() %>/AdminController?action=logout" class="button special">Logout</a></li>
	
	<%}else{ %>
	<li><a href="<%=request.getContextPath() %>/JSP/register.jsp" class="button special">Sign Up </a></li>
	<li><a href="<%=request.getContextPath() %>/JSP/Login1.jsp" class="button special">Login</a></li>
<%} %>
</ul>
</nav>
</header>



<!-- Main -->



<!-- Three -->
<section id="banner">
				
				<!--
					".inner" is set up as an inline-block so it automatically expands
					in both directions to fit whatever's inside it. This means it won't
					automatically wrap lines, so be sure to use line breaks where
					appropriate (<br />).
				-->

<div class="inner">
<%String name1=null;  
if(request.getSession(false).getAttribute("name")!=null){
name1=request.getSession(false).getAttribute("name").toString();}
     ArrayList<Order> orders=(ArrayList<Order>) request.getAttribute("orders");
    ArrayList<Outlet> outletlist=(ArrayList<Outlet>)request.getAttribute("outlet");
     %><center><h2>ABC Retail Company</h2></center>
<form name="OrderList" method="post">

<%if(request.getSession().getAttribute("name")!=null){%>
	<caption><strong>Dear <%=name1%></strong></caption><br>
<caption><strong><u>ORDER DETAILS </u></strong></caption><%} %>
	<br>
	<%if(orders.size()>0 && outletlist.size()>0){%>
	<table border="1">
	<tr>
		<th>Order Number</th>
		<th>Time of Order</th>
		<th>Item Id</th>
		<th>Quantity</th>
		<th>Total Amount(&#36)</th>
		<th>Outlet Id</th>
		<th>Outlet Address</th>
	</tr>
	<%
	double cost=0.0;
	for(Order order: orders){ 
	cost=cost+order.getAmount();
	%>
	<tr>
		<td><%=order.getOrderNo() %></td>
		<td><%=order.getCurrentTimestamp() %></td>
		<td><%=order.getItemId()%></td>
		<td><%=order.getQuantity() %></td>
		<td><%=order.getAmount() %></td>
		<td><%=order.getOutletId()%></td>
		<%
		for(Outlet outlet:outletlist)
		{
		if(order.getOutletId()==outlet.getOutletId())
		{
			%>
			<% System.out.println("OUTLET id="+order.getOutletId());%>
		
		<td><%=outlet.getAddress()%>,<%=outlet.getCity()%>,<%=outlet.getZipCode()%></td>
		<%
		break;
		}
		}
		%>
	</tr>
	<%} %><tr><td>&nbsp;</td></tr>
	<tr><td colspan="7">Total amount(&#36):<%=cost %></td></tr>
</table>
<%}else{ %>
<h1>no orders found</h1><%} %>


<% if(request.getSession()!=null && request.getSession(false).getAttribute("name")!=null){
	%> 

	<a href="<%=request.getContextPath()%>/JSP/home.jsp "> Home </a> 
	<%}else{ 
	%>
	<a href="<%=request.getContextPath()%>/JSP/welcome.jsp "> Home </a>
	<%} %>
</form>
</div>
</section>
</body>
</html>