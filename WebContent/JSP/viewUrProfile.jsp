<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tcs.ilp.POJO.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABC Retail Registration</title>
</head>
<body>
	<%
		int count = 0;
	%>
	<%
		User customers = (User) request.getAttribute("Profile");
		if (customers != null) {
	%>
	<table border="1" cellpadding="10px" align="center">
		
		<tr>
			<td>Id</td><td><%=customers.getUser_Id()%></td></tr><tr>
			<td>Password</td><td><%=customers.getPassword()%></td></tr><tr>
			<td>Name</td><td><%=customers.getName()%></td></tr><tr>
			<td>DOB</td><td><%=customers.getDob()%></td></tr><tr>
			<td>Gender</td><td><%=customers.getGender()%></td></tr><tr>
			<td>Email</td><td><%=customers.getEmail()%></td></tr><tr>
			<td>Address</td><td><%=customers.getAddress()%></td></tr><tr>
			<td>City</td><td><%=customers.getCity()%></td></tr><tr>
			<td>State</td><td><%=customers.getState()%></td></tr><tr>
			<td>ZipCode</td><td><%=customers.getZipcode()%></td></tr><tr>
			<td>Phone</td><td><%=customers.getPhone()%></td></tr><tr>
			<td>Category</td><td><%=customers.getCategory()%></td></tr><tr>
			<td colspan="2" align="center"><a href="<%=request.getContextPath()%>/CustomerController?update=<%=customers.getUser_Id()%>&action=updateform&count=count">Update</a></td>
		</tr>

	</table>
	<%
		} else {
	%>
	<table>
		<tr>
			<td>Sorry</td>
		</tr>
	</table>
	<%
		}
	%>
	<a href="JSP/home.jsp">HOME</a>
</body>
</html>