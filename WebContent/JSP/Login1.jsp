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
<link rel="stylesheet" href="<%=request.getContextPath() %>/CSS/skel.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/CSS/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/CSS/style-wide.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/CSS/style-noscript.css" />

<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
<script src="<%=request.getContextPath() %>/JS/jquery.min.js"></script>
<script src="<%=request.getContextPath() %>/JS/validate.js"></script>
<script src="<%=request.getContextPath() %>/JS/jquery.dropotron.min.js"></script>
<script src="<%=request.getContextPath() %>/JS/jquery.scrolly.min.js"></script>
<script src="<%=request.getContextPath() %>/JS/jquery.scrollgress.min.js"></script>
<script src="<%=request.getContextPath() %>/JS/skel.min.js"></script>
<script src="<%=request.getContextPath() %>/JS/skel-layers.min.js"></script>
<script src="<%=request.getContextPath() %>/JS/init.js"></script>



<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
</head>
<body class="index">
<script type="text/javascript">
function logincheck(){
	
	var ereg=/^([A-Z a-z 0-9_\-\.])+\@([A-Z a-z 0-9_\-\.])+\.([A-Z a-z]{2,4})$/;
	var email=document.getElementById("username").value;
	
	
	
	if(email="" || email==null){ alert("please provide email");
	return false;
	}
	var password=document.getElementById("password").value;
	}
	if(password==null){
		alert("please provide password");
		return false;
	}
	else{
		return true;
	}
</script>

<!-- Header -->
<header id="header" class="alt">
<h1 id="logo"><a href="<%=request.getContextPath()%>/JSP/aboutus.jsp">ABC Company <span>Retail</span></a></h1>
<nav id="nav">
<ul>
	<li class="current">Welcome</li>
	<!-- <li class="submenu"><a href="">Departments</a>
	<ul>
		<li><a href="#">Cosmetics</a></li>
		<li><a href="#">Bakery</a></li>
		<li><a href="#">Dairy</a></li>
		<li><a href="#">Deli Products</a></li>
		<li><a href="#">Daily Consumables</a></li>
		<li><a href="#">Sea Food</a></li>

		<li class="submenu"><a href="">New In Store</a>
		<ul>
			<li><a href="#">Choclates</a></li>
			<li><a href="#">Kids Section</a></li>
			<li><a href="#">Fruits Section</a></li>
			<li><a href="#">20% Discount on dairy product</a></li>

		</ul>
		</li>
	</ul>
	</li>
	<li><a href="#" class="button special">Cart </a></li> -->
	<li><a href="<%=request.getContextPath() %>/JSP/register.jsp" class="button special">SignUp </a></li>
</ul>
</nav>
</header>

<!-- Banner -->
<section id="banner">

<!--
					".inner" is set up as an inline-block so it automatically expands
					in both directions to fit whatever's inside it. This means it won't
					automatically wrap lines, so be sure to use line breaks where
					appropriate (<br />).
				-->
<div class="inner"><header>
<p><strong>Login</strong></p>
</header>
<form  name="login"  method="post" action="<%=request.getContextPath()%>/AdminController" >
<input type="hidden" name="action" value="login">
<table>
		<tr><td>USERNAME</td><td><input type="text" required  name="username" id="username" placeholder="E-Mail"></td></tr>
		<tr><td>PASSWORD</td><td><input type="password" required name="password"  id="password" placeholder="password"></td></tr>
		</table>
		<input type="submit" class="button special" value="Login" onclick="return logincheck()">&nbsp<input type="reset" value="Reset" class="button special">
</form>

<footer>
<ul class="buttons vertical">
	<li><a href="<%=request.getContextPath() %>/CustomerController?action=DeleteGuestCart" class="button fit scrolly">Enter as Guest</a></li>
</ul>
</footer></div>

</section>







<!-- Footer -->
<footer id="footer">

<ul class="copyright">
	<li>&copy; ABC Retail</li>
	<li>Design: <a href="">GROUP F</a></li>
</ul>

</footer>

</body>
</html>