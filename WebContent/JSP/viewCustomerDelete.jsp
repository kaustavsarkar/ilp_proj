<%@page import="com.tcs.ilp.POJO.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList,com.tcs.ilp.POJO.User"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"  src="<%= request.getContextPath()%>/js/confirm.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>ABC Online Retail Store</title>
</head>
<html>
<head>
<title>ABC Retail Registration</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="<%=request.getContextPath()%>/JS/validate.js"></script>
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
<ul><%request.getSession().invalidate(); %>
		
<!-- <li class="current"><a href="">Welcome Admin</a></li> -->
	<li class="current"><a href="<%=request.getContextPath()%>/JSP/admin.jsp">Welcome Admin</a></li>
			<li class="submenu"><a href="">Actions</a>
	
	<ul>
		<li><a href="<%=request.getContextPath() %>/JSP/managedepartment.jsp">Manage Departments</a></li>
		<li><a href="<%=request.getContextPath() %>/JSP/manageitems.jsp">Manage Items</a></li>
		<li><a href="<%=request.getContextPath() %>/JSP/manageoutlets.jsp">Manage Outlets</a></li>
		<li><a href="<%= request.getContextPath()%>/AdminController?action=viewcustomersdetail">Manage Customers</a></li>
	</ul>
	</li>
		

	<li>	<a href="<%=request.getContextPath() %>/JSP/Login1.jsp" class="button special">Logout</a></li>

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


<div class="inner"><header>
<p><strong>Customer Details</strong></p>
</header>
<body>

<% 
User user=(User) request.getAttribute("user"); 
%>

<form method="post" name="deleteconfirm" action="<%=request.getContextPath()%>/AdminController" >
<%---  
<action="<%=request.getContextPath()%>/AdminController?Id=<%=request.getParameter("id")%>">
--%>
<fieldset>
<legend>Confirmation Delete Page</legend>
<table border="1" >
<% //int id=user.getUser_Id(); %>
<tr><td>ID</td><td align="center"><input name="Id" value="<%=user.getUser_Id()%>"  readonly /></td></tr>
<tr><td>Name</td><td><%=user.getName()%></td></tr>
<tr><td>DOB</td><td><%=user.getDob()%></td></tr>
<tr><td>Gender</td><td><%=user.getGender()%></td></tr>
<tr><td>Email</td><td><%=user.getEmail()%></td></tr>
<tr><td>Address</td><td><%=user.getAddress()%></td></tr>
<tr><td>City</td><td><%=user.getCity()%></td></tr>
<tr><td>State</td><td><%=user.getState()%></td></tr>
<tr><td>Zipcode</td><td><%=user.getZipcode()%></td></tr>
<tr><td>Phone</td><td><%=user.getPhone()%></td></tr>
<tr><td colspan="2" align="center">
<input type="submit" value="Confirm Delete" name="action" onclick="<%=request.getContextPath()%>/AdminController"> 

</td>
</tr>


<%---
<a href="<%=request.getContextPath()%>/AdminController?action=deleteCustomerview&id=<%=user.getUser_Id() %>" onclick="return confirm('Are you sure you want to delete ?');">
<input type="submit" value="Confirm Delete" /></a>
</td>
</tr>

<input type="submit" value="Confirm Delete" onclick="deleteRecord(<%=user.getUser_Id()%>);">
<input type="hidden" id="action" name="action" value="deleteCustomerview"/>
 --%>
</table>
<a href="<%=request.getContextPath()%>/JSP/admin.jsp" class="button">Home</a>
<%-----
<button  onclick="<%=request.getContextPath()%>/JSP/admin.jsp" >Cancel button</button>
 --%>

<%----  
<button  type="submit" value="Cancel" onclick="<%=request.getContextPath()%>/JSP/viewcustomersdetail.jsp">
 --%>
<br></br>
<a onclick="javascript:history.go(-1)" >Back</a><!-- 
<input align="middle" type="button" value="Back" onclick="javascript:history.go(-1)"> -->
</fieldset>
</form> 
</div></section>
</body>
</html>