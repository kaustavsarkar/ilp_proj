<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GROUP F PAYMENT GATEWAY</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/payment.js"></script>
</head>
<body>
<%-- <H1><%=Integer.parseInt(request.getSession().getAttribute("outletid").toString())%></H1>  --%>
<form name="makepayment"  onsubmit="return validate()" method="post" action="<%=request.getContextPath()%>/JSP/MakePayment.jsp">

<fieldset style="width:50%;align:center; ">
<legend>GROUP F PAYMENT GATEWAY</legend>
<table>
<tr>
	<td>Card Number</td>
	<td><input type="text" name="cardnumber" id="cardnumber"></td>
</tr>

<tr>
	<td>CVV Number</td>
	<td><input type="password" name="cvv" id="cvv" maxlength="3"></td>	

</table>
<a href="<%=request.getContextPath()%>/JSP/MakePayment.jsp" class="button special">Pay</a>
</fieldset>
</form>
</body>
</html>