<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.tcs.ilp.POJO.Cart,com.tcs.ilp.POJO.Items,com.tcs.ilp.POJO.Outlet,java.util.ArrayList,java.util.Arrays"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<title>ABC Online Retail Store</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<%-- <script src="<%=request.getContextPath() %>/JS/jquery.min.js"></script> --%>
<script src="<%=request.getContextPath()%>/JS/jquery.dropotron.min.js"></script>
<script src="<%=request.getContextPath()%>/JS/jquery.scrolly.min.js"></script>
<script src="<%=request.getContextPath()%>/JS/jquery.scrollgress.min.js"></script>
<script src="<%=request.getContextPath()%>/JS/skel.min.js"></script>
<script src="<%=request.getContextPath()%>/JS/skel-layers.min.js"></script>
<script src="<%=request.getContextPath()%>/JS/init.js"></script>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>

<link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/skel.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/style-wide.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/style-noscript.css" />

<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Cart</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" type="text/css"></link>
</head>
<body class="index"  >
<script type="text/javascript">
function abc(cities){
	alert("into abc");
	var state=document.getElementById("state").value;
	alert(state);
	alert(cities);
	var count= new Array();
	var selcities=new Array();
	var html=new Array();
	var j=0;
	var tot="";
	for(var i=0;i<cities.length;i++){
		if(states[i]==state){
			selcities[j]=cities[i];
			html[j]="<option value='"+selcities[j]+"'>"+selcities[j]+"</option>";
			tot=tot+html[j];
			j++;
		}
	
	}
	document.getElementById("city").innerHTML=tot;
	
	
}

</script>

<script>
$(document).ready(function() {
	$('#tablediv').hide();
        $('#state').change(function(event) {
                var states = $("select#state").val();
               /*  alert(states); */
                $.get('<%=request.getContextPath()%>/CustomerController', {
                        stateName : states
                        
                }, function(jsonResponse) {
                	/* alert(jsonResponse); */
                        var select = $('#city');
                        select.find('option').remove();
                        $.each(jsonResponse, function(index, value) {
                                $('<option>').val(value).text(value).appendTo(select); 
                        });
                });
        });
        
          	 $('#city').change(function(event){
        		
        		 var cities = $("select#city").val();
               /*   alert(cities); */
                   $.get('<%=request.getContextPath()%>/CustomerController', {
                       cityName : cities                      
                   },function(jsonResponse) {
                	  
                    	
                        $("#outletTable").find("tr:gt(0)").remove();
                        var table1 = $("#outletTable");
                        $.each(jsonResponse, function(key,value) { 
                             var rowNew = $("<tr><td id='1'></td><td></td><td></td><td></td><td></td></tr>");
                           
                             $('<input type=radio id=outletId name=radio>').val(value['outletId']).appendTo(rowNew.children().eq(0)); 
                                rowNew.children().eq(1).text(value['address']); 
                                rowNew.children().eq(2).text(value['city']); 
                                rowNew.children().eq(3).text(value['state']); 
                                rowNew.children().eq(4).text(value['zipCode']);
                                rowNew.appendTo(table1);
                        });
                        
                    });
                    $("#tablediv").show();          
          });      
});
        
</script>



<!-- Header -->
<header id="header" class="alt">
<h1 id="logo"><a href="<%=request.getContextPath()%>/JSP/aboutus.jsp">ABC Company <span>Retail</span></a></h1>
<nav id="nav">
<ul>
<%String name=null; 
int a=0;
if(request.getSession().getAttribute("name")!=null){
	System.out.println("session is there");
	name=(String)session.getAttribute("name"); 
			a=Integer.parseInt(session.getAttribute("Id").toString());}%>
<%
if(null != request.getSession().getAttribute("name")){ %>

	<li class="current"><a href="<%=request.getContextPath()%>/JSP/home.jsp">Welcome &nbsp <%=name %></a></li>
	<li class="submenu"><a href="">Departments</a>
	<%}else{ %>
	<li class="current"><a href="<%=request.getContextPath()%>/JSP/welcome.jsp">Welcome</a></li>
	<li class="submenu"><a href="">Departments</a>
	<%} %>
	<ul>
		<li><a href="<%=request.getContextPath()%>/CustomerController?name=Cosmetics&action=getitems">Cosmetics</a></li>
		<li><a href="<%=request.getContextPath()%>/CustomerController?name=bakery&action=getitems">Bakery</a></li>
		<li><a href="<%=request.getContextPath()%>/CustomerController?name=dairy&action=getitems">Dairy</a></li>
		<li><a href="<%=request.getContextPath()%>/CustomerController?name=deli&action=getitems">Deli Products</a></li>
		<li><a href="<%=request.getContextPath()%>/CustomerController?name=daily consumables&action=getitems">Daily Consumables</a></li>
		<li><a href="<%=request.getContextPath()%>/CustomerController?name=seafood&action=getitems">Sea Food</a></li>

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
	
	<%if(request.getSession().getAttribute("name")!= null && name!=null) 
	{
	%>
	
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
		double[] quantity =(double[])request.getAttribute("quantity");
		int i=0;
		ArrayList<Items> itemCart = (ArrayList<Items>) request.getAttribute("itemList");
		ArrayList<Outlet> outlets = (ArrayList<Outlet>) request.getAttribute("outlets");
		
		if (itemCart.size() > 0) { %>
<form name="CartItemView" method="post" action="<%=request.getContextPath()%>/CustomerController">
<div>
<input type="hidden" name="action" value="setoutletid">
<table border="0">
	<caption><strong><u>ORDER DETAILS </u></strong></caption>
	<br></br>
	<tr>
		
		<th>Item Name</th>
		<th>Price(&#36)</th>
		<th>Quantity</th>
	</tr>
	
		<input type="hidden" value="confirmOrder" name="action"></input>
	<%
		for (Items item : itemCart) {
	%>
<input type="hidden" value="<%=item.getItemId()%>" name="ItemId"></input>
<input type="hidden" value="addOrder" name="action">
	<tr>
		
		
		<td><%=item.getItemName()%></td>
		<td><%=item.getPrice()*quantity[i]%></td>
		<td><%=quantity[i++]%></td>
	</tr>
	<%
		}
	%></table>
	<caption><strong><u>SELECT OUTLET </u></strong></caption>
	<table>

	<td>
	<%String[] states=new String[outlets.size()];
	String[] cities=new String[outlets.size()];
	int j=0;
	if(outlets.size()>0 ){
	for(Outlet outlet:outlets){ 
	states[j]=outlet.getState();
	cities[j]=outlet.getCity();
	j++;
	}}%>
	
	<select id="state" name="state" ><option value="" >--Select--</option> <%
	for(int k=0;k<states.length-1;k++){
		%><h1><%=states[k]%></h1><%
		if(!states[k].equals(states[++k])){
	%><option value="<%=states[k]%>"><%=states[k] %></option> 
	
	<%}}%><td><select id="city"><option value="">--Select--</option></select>
	</tr>


</table> 

<div id="tablediv" style="align:center;width:80%;">
<table id="outletTable"><tr><th>Select</th><th>Address</th><th>City</th><th>State</th><th>ZipCode</th></tr></table>

</div>
<table ><tr>
<td colspan="3" ><input type="submit" value="Confirm Order"></td></tr></table>
<%
	} else {
%>
<table>
	<tr>
		<td>No Item Exists in the Data Base</td>
	</tr>
</table>

<%
	}%> <a href="javascript:history.go(-1)" >Back</a><%
		
		
		if(request.getSession()!=null && request.getSession(false).getAttribute("name")!=null){
%> 
<br>
<a href="<%=request.getContextPath()%>/JSP/home.jsp "> Home </a> 
<%}else{ 
%><br>
<a href="<%=request.getContextPath()%>/JSP/welcome.jsp "> Home </a>
<%} %>
<!-- <input align="middle" type="link" value="Back" onclick="javascript:history.go(-1)"> -->


</div>
</form>
</div>
</section>
</body>
</html>