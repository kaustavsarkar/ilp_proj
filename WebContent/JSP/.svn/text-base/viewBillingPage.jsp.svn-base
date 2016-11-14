<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.tcs.ilp.POJO.Order,com.tcs.ilp.POJO.Outlet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABC Online Retail Store</title>
</head>
<body>
<script>
function abc(){
	/* alert("into abc"); */
	document.getElementById("print").style.display='none';
	
	/* alert("into abc1"); */
	window.print();
	setTimeout(function(){document.getElementById("print").style.display='block';}, 5000);
	/* alert("into abc2"); */
	return false;
}


</script>
<div align="center">
<%String name=null;  
if(request.getSession().getAttribute("name")!=null){
name=request.getSession(false).getAttribute("name").toString();}
     ArrayList<Order> orders=(ArrayList<Order>) request.getAttribute("orders");
    Outlet outlet=(Outlet)request.getAttribute("outlet");
     %><center><h2>ABC Retail Company</h2></center>
<form name="OrderList" method="post">

<%if(request.getSession().getAttribute("name")!=null){%>
	<caption><strong>Dear <%=name%></strong></caption><br><%} %>
<caption><strong><u>ORDER DETAILS </u></strong></caption>
	<br>
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
		<td><%=order.getOutletId() %></td>
		<td><%=outlet.getAddress() %>,<%=outlet.getCity() %>,<%=outlet.getZipCode() %></td>
		
	</tr>
	<%} %><tr><td>total amount(&#36):<%=cost %></td></tr>
</table>
<div id="print"><button onclick="abc()">Print</button><br>
<% if(request.getSession()!=null && request.getSession(false).getAttribute("name")!=null){
	%> 

	<a href="<%=request.getContextPath()%>/JSP/home.jsp "> Home </a> 
	<%}else{ 
	%>
	<a href="<%=request.getContextPath()%>/JSP/welcome.jsp "> Home </a>
	<%} %>
</form>
</div>
</body>
</html>