<%@page import="java.util.ArrayList,com.tcs.ilp.POJO.Items"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ITEMS IN TABLE</title>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<%-- <script src="<%=request.getContextPath() %>/JS/jquery.min.js"></script> --%>
<script src="<%=request.getContextPath() %>/JS/jquery.dropotron.min.js"></script>
<script src="<%=request.getContextPath() %>/JS/jquery.scrolly.min.js"></script>
<script src="<%=request.getContextPath() %>/JS/jquery.scrollgress.min.js"></script>
<script src="<%=request.getContextPath() %>/JS/skel.min.js"></script>
<script src="<%=request.getContextPath() %>/JS/skel-layers.min.js"></script>
<script src="<%=request.getContextPath() %>/JS/init.js"></script>

<%-- <link rel="stylesheet" href="<%=request.getContextPath() %>/CSS/skel.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/CSS/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/CSS/style-wide.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/CSS/style-noscript.css" /> --%>

<link rel="stylesheet" href="<%=request.getContextPath() %>/CSS/viewItems.css" />

</head>
<body>
<%String name=null; 
int a=0;

if(request.getSession().getAttribute("name") != null)
{
	System.out.println("Session is  there");
	%><%
	name=(String)request.getSession(false).getAttribute("name"); 
	System.out.println(name);
			a=Integer.parseInt(request.getSession(false).getAttribute("Id").toString());
			
}
 ArrayList<Items> items=new ArrayList<Items>();
 items=(ArrayList<Items>)request.getAttribute("items");

int i=0;


%>
<header id="header" class="alt">
<h1 id="logo"><a >ABC Company <span>Retail</span></a></h1>
<nav id="nav">
<ul>
	<%if(request.getSession(false)!=null  && name!=null){ %>

	<li class="current"><a href="<%=request.getContextPath()%>/JSP/home.jsp">Welcome &nbsp <%=name %></a></li>
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
	<li><a href="<%=request.getContextPath() %>/CustomerController?name=Cosmetics&action=CartViewer&customerId=<%=a %>" class="button special">Cart </a></li>
	<%if(request.getSession(false) != null && name!=null)
	{
	%>
	
	<li><a href="<%=request.getContextPath() %>/CustomerController?action=viewUrProfile" class="button special">View Profile </a></li>
	<li><a href="JSP/Login1.jsp" class="button special">Logout</a></li>
	<%}else{ %>
	<li><a href="JSP/register.jsp" class="button special">Sign Up </a></li>
	<li><a href="JSP/Login1.jsp" class="button special">Login</a></li>
<%} %>
</ul>
</nav>
</header>
<section id="banner">

<form action="<%=request.getContextPath() %>/CustomerController" method="post">
<input type="hidden" name="action" value="cartselection" >
<input type="hidden" name="id" value="<%=request.getSession(false).getAttribute("Id") %>" >

<table cellpadding="5px" align="center"><tr><th>Select</th>
<th>Name</th><th>Price</th></tr>

<%if(items!=null){
 for(Items item: items){
 %>
 <tr><td><input type="checkbox" name="items" value="<%=item.getItemId()%>"></td><td><p><%=item.getItemName() %></p></td><td><%=item.getPrice() %></td></td></tr>	

<%}%>
<tr><td colspan="4"><input type="submit" class="button special" value="Add To Cart" onclick="<%=request.getContextPath() %>/CustomerController?id=<%=request.getSession(false).getAttribute("Id") %>"></td></tr>

<%}else{ %>

<tr><td><h1>under Maintenance</h1></td></tr>





<%}%>
<tr><td colspan="3"><a href="javascript:history.go(-1)" style="color:cyan; size:12px"> Back </a></td></tr>

</table>
</form>
</section>
</body>
</html>