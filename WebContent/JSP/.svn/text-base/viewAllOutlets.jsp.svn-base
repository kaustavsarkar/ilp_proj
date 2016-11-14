   <%@ page import="java.util.ArrayList,com.tcs.ilp.POJO.Outlet"%>
   <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<!--
	Twenty by HTML5 UP
	html5up.net | @n33co
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>ABC Online Retail Store</title>
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
	<li class="current"><a href="<%=request.getContextPath()%>/JSP/admin.jsp">Welcome Admin</a></li>	<li class="submenu"><a href="">Actions</a>
	
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
<p><strong>Manage Outlets</strong></p>
</header>
<%
	ArrayList<Outlet> outletList = (ArrayList<Outlet>) request.getAttribute("outletList");
	if (outletList.size() > 0) {
%> 
<form name="listofOutlet" method="post" action="<%=request.getContextPath()%>/AdminController" >
<caption><strong>OUTLET DETAILS</strong></caption>
<table border="1">
	<tr><td>Select</td>
		<td>OutletId</td>
		<td>address</td>
		<td>state</td>
		<td>city</td>
		<td>zipcode</td>
		<td>UPDATE/DELETE</td>
	</tr>
	<%
			for (Outlet outlet : outletList) {
		%>
	<tr>
		<td><input type="checkbox" name="selectid" id="selectid" value="<%=outlet.getOutletId()%>"></td>
		<td><%=outlet.getOutletId() %></td>
		<td><%=outlet.getAddress() %></td>
		<td><%=outlet.getState() %></td>
		<td><%=outlet.getCity() %></td>
		<td><%=outlet.getZipCode() %></td>
		<td><a href="<%=request.getContextPath()%>/AdminController?action=searchoutlet&outletid=<%=outlet.getOutletId()%>">Update/Delete</a></td>
		
	</tr>
	<%
			}
	%>
</table>
<input type="submit" value="delete all" name="action" onclick="<%=request.getContextPath()%>/AdminController">
<%
	} else {
	%>
<table>
	<tr>
		<td>SORRY THE DATABASE IS UNDER MAINTENANCE.......<br>
		PLEASE TRY AFTER SOMETIME OR CONTACT YOUR DATABASE ADMINISTRATOR....</td>
	</tr>
</table>
<%
		}
	%> <br></br>
<a href="javascript:history.go(-1)"> back </a>

<br></br>

</fieldset>
</form>
</div></section>
</body>
</html>