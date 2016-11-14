<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.ArrayList"%>
<%@page import="com.tcs.ilp.POJO.User"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Profile</title>
</head>
<body>
<% User customer=(User)request.getAttribute("update");%>
<form method="post" action="<%=request.getContextPath()%>/CustomerController" >
<fieldset>
<legend>Update PROJECT</legend>

<table>
<%
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date date=format.parse(customer.getDob());
if(customer!=null){%>
<tr><td>ID</td><td><input type="text" name="userid" value="<%=customer.getUser_Id() %>" readonly/></td></tr>
<tr><td>Password</td><td><input type="password" id="password" name="password" value="<%=customer.getPassword()%>"></td></tr>
<tr><td>Name</td><td><input type="text" id="name" name="name" value="<%=customer.getName()%>"></td></tr>
<tr><td>Date of Birth </td><td><input type="date" id="dob" name="dob" value="<%=date%>"></td></tr>


<% int count=0;
				if(customer.getGender().equalsIgnoreCase("male")){
					count=1;
				}else{
					count=2;
				}


if(count==1){
%>
<tr><td>Gender</td><td>
<input type="radio" id="gender" name="gender" value="Male" checked >Male</input>
<input type="radio" id="gender" name="gender" value="Female" >Female</input>
</td></tr>
<%
}else{
%>
<tr><td>Gender</td><td>
<input type="radio" id="gender" name="gender" value="Male"  >Male</input>
<input type="radio" id="gender" name="gender" value="Female" checked ></input>
</td></tr>
<%
}
%>


<tr><td>Email</td><td><input type="text" id="email" name="email" value="<%=customer.getEmail()%>"></td></tr>
<tr><td>Address</td><td><input type="text" id="address" name="address" value="<%=customer.getAddress()%>"></td></tr>
<tr><td>City</td><td><input type="text" id="city" name="city" value="<%=customer.getCity()%>"></td></tr>
<tr><td>State</td><td><input type="text" id="state" name="state" value="<%=customer.getState()%>"></td></tr>
<tr><td>ZipCode</td><td><input type="text" id="zipcode" name="zipcode" value="<%=customer.getZipcode()%>"></td></tr>
<tr><td>Phone</td><td><input type="text" id="phone" name="phone" value="<%=customer.getPhone()%>"></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="Update"></td></tr>
<input type="hidden" id="action" name="action" value="update">
</table>
<%}else{%>

<h3>not updated</h3><% }%>

<input type="hidden" id="id" name="id" value="<%=customer.getUser_Id()%>">
</fieldset>

</form> 

</body>
</html> 

