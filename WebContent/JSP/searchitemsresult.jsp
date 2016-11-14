<%@ page import="java.util.ArrayList,com.tcs.ilp.POJO.Items" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.tcs.ilp.Services.AdminServices,java.util.ArrayList,com.tcs.ilp.POJO.Department"%>
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
<p><strong>Update Item</strong></p>
</header>

<div class="row">
<body>


<div >

</div>
<div align="center">
<% 
Items items=(Items) request.getAttribute("items"); 
%>
<form onsubmit="return validateUpdateItem()" name="updateitems" method="post" action="<%=request.getContextPath()%>/AdminController">
<table align="center">
<tr><td>ITEM ID</td><td><input type="text" name="itemid" id="itemid" value="<%=items.getItemId() %>" readonly></td></tr>
<tr><td>ITEM NAME</td><td><input type="text" name="itemname" id="itemname" value="<%=items.getItemName() %>"></td></tr>
<%
AdminServices adminservices=new AdminServices();
ArrayList<Department> departmentList=new ArrayList<Department>(); 
departmentList=adminservices.viewDepartment();
%>
<tr><td>DEPARTMENT ID</td>
<td><select id="departmentid" name="departmentid">
<option value="">---select---</option>
<%for(Department dept:departmentList)
	{
	
if(items.getDepartmentId()==dept.getDepartmentId()){
	%>
	<option value=<%=dept.getDepartmentId()%>  selected ><%=dept.getDepartmentName()%></option>
	<%
}else {
	%>
	<option value=<%=dept.getDepartmentId()%>  ><%=dept.getDepartmentName()%></option>
	<%
}
}
%>
</select>
</td>
</tr>
<%---- 
<tr><td>DEPARTMENT ID</td><td><input type="text" name="departmentid" id="departmentid" value="<%=items.getDepartmentId() %>"></td></tr>
 --%>
<tr><td>PRICE</td><td><input type="text" name="price" id="price" value="<%=items.getPrice() %>"></td></tr>
<tr><td>QUANTITY</td><td><input type="text" name="quantity" id="quantity" value="<%=items.getQuantity() %>"></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="UPDATE">
</table>
<input type="hidden" name="action" value="updateitems">
<input align="middle" type="button" value="Back" onclick="javascript:history.go(-1)">
</form>
</div>



</body>

</section>
</body>
</html>