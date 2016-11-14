<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% int departmentId= Integer.parseInt(request.getAttribute("departmentId").toString()); 

if(departmentId>0){
%>
Congrats!!

department  <%=departmentId %> added successfully.
<br></br>
<a href="<%= request.getContextPath()%>/JSP/managedepartment.jsp "> back </a>

<br></br>
Click <a href="<%= request.getContextPath()%>/JSP/admin.jsp "> Home </a>
to go to home page
<%

}
else {
%>
department not added.. !!
<br></br>
<a href="<%= request.getContextPath()%>/JSP/managedepartment.jsp "> back </a>

<br></br>
Click <a href="<%= request.getContextPath()%>/JSP/admin.jsp "> Home </a>
to go to home page
<%
}%>

</body>
</html>