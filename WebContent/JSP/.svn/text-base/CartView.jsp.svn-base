<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.tcs.ilp.POJO.Cart,com.tcs.ilp.POJO.Items,java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<script src="<%=request.getContextPath()%>/JS/validate.js"></script>

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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Cart</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" type="text/css"></link>
</head>
<body class="index"  >



<!-- Header -->
<header id="header" class="alt">
<h1 id="logo"><a href="<%=request.getContextPath()%>/JSP/aboutus.jsp">ABC Company <span>Retail</span></a></h1>
<nav id="nav">
<ul>

<% String name=null; 
int a=0;
if(null != request.getSession().getAttribute("name")){name=(String)request.getSession().getAttribute("name"); 
a=Integer.parseInt(request.getSession().getAttribute("Id").toString());}
	
	if(null != request.getSession(false) && name!=null){ %>

	<li class="current"><a href="<%=request.getContextPath()%>/JSP/home.jsp ">Welcome &nbsp <%=name %></a></li>
	<li class="submenu"><a href="">Departments</a>
	<%}else{ %>
	<li class="current"><a href="<%=request.getContextPath()%>/JSP/welcome.jsp">Welcome</a></li>
	<li class="submenu"><a href="">Departments</a>
	<%} %>
	<ul>
		<li><a href="<%=request.getContextPath() %>/CustomerController?name=Cosmetics&action=getitems">Cosmetics</a></li>
		<li><a href="<%=request.getContextPath() %>/CustomerController?name=bakery&action=getitems">Bakery</a></li>
		<li><a href="<%=request.getContextPath() %>/CustomerController?name=dairy&action=getitems">Dairy</a></li>
		<li><a href="<%=request.getContextPath() %>/CustomerController?name=deli&action=getitems">Deli Products</a></li>
		<li><a href="<%=request.getContextPath() %>/CustomerController?name=daily consumables&action=getitems">Daily Consumables</a></li>
		<li><a href="<%=request.getContextPath() %>/CustomerController?name=seafood&action=getitems">Sea Food</a></li>

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
	<li><a href="#" class="button special">Cart </a></li>
	<%if(null != request.getSession(false) && name!=null){  %>
	<li><a href="<%=request.getContextPath() %>/CustomerController?action=viewUrProfile" class="button special">View Profile </a></li>
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

<%
int i=0;
	if (request.getSession(false)!= null) {
		ArrayList<Items> itemCart = (ArrayList<Items>) request.getAttribute("itemCart");
		if (itemCart.size() > 0) {
%>
<form name="CartItemView" onsubmit="return validateCartView();" method="post"
	action="<%=request.getContextPath()%>/CustomerController">
<fieldset>
<div>
<table border="0">
	<caption><strong><u>Cart DETAILS </u></strong></caption>
	<br></br>
	<tr>
		<th>Select</th>
		<th>Item Name</th>
		<th>Price<br>($)</th>
		<th>Quantity</th>
	</tr>
	<%
		for (Items item : itemCart) {
	%>
	<input type="hidden" value="Order" name="action"></input>
	<tr>
		<td><input type="checkbox" value="<%=item.getItemId()%>" name="itemcart" id="itemcart"></input></td>
		<td><%=item.getItemName()%></td>
		<td><%=item.getPrice()%></td>
		<td><select  name="quantity<%=item.getItemId()%>" id="quantity<%=i++ %>"  onmousedown="if(this.options.length>=2){this.size=2;}"  onchange='this.size=0;' onblur="this.size=0;"><option value="">--Select--</option>
		<%for(int j=1;j<=item.getQuantity();j++){%><option value="<%=j%>"><%=j%></option><%} %>
		</select> </td>
	</tr>
	<%
		}
	%>
</table>
<td><input type="submit" value="Order" name="action"></input>&nbsp
<%if(request.getSession(false)!=null && request.getSession(false).getAttribute("name")!=null){%>
<a href="<%=request.getContextPath()%>/JSP/home.jsp " class="button"> Cancel </a>
<%}else{ %>
<a href="<%=request.getContextPath()%>/JSP/welcome.jsp " class="button"> Cancel </a>
<%} %> 



<a href=""></td>
<%
	} else {
%> 
<table>
	<tr>
		<td>No Item Exists in the Data Base</td>
	</tr>
</table>
<%
	}
	}
%> <br></br>
<%if(request.getSession(false)!=null && request.getSession(false).getAttribute("name")!=null){%>
<a href="<%=request.getContextPath()%>/JSP/home.jsp "> Home </a>
<%}else{ %>
<a href="<%=request.getContextPath()%>/JSP/welcome.jsp "> Home </a>
<%} %> 
<br>
 <a href="javascript:history.go(-1)">Back</a>
</div>
</fieldset>
</form>
</div>
</section>
</body>
</html>