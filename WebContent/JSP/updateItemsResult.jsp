<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="head">
<h1 align="center"><u>Success Page</u></h1>
</div>
<div align="center">
<%
int count=Integer.parseInt(request.getAttribute("updateCount").toString());
if(count > 0)
{
%>

Item <%=request.getAttribute("itemid") %> is updated
<%
}
else
{
%>
Item not updated.
<%
}
%>
<a href="<%=request.getContextPath()%>/JSP/manageitems.jsp" >LOGIN</a>
</div>
</body>
</html>