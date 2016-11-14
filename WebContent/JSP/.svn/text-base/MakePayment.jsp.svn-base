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
	<form name="pay"  action="<%=request.getContextPath()%>/CustomerController" method="post">
	<input type="hidden" name="action" value="addOrder">

		<fieldset>
			<legend>GROUP F PAYMENT GATEWAY</legend>
			<table>
				<tr>
					<td>Enter Your OTP<br>OR<br>Password</td>
					<td><input type="password" name="pass" id="pass"></td>
			</table>
			<input type="submit" value="Pay" onclick="return validatePayment()">
		</fieldset>
	</form>
</body>
</html>