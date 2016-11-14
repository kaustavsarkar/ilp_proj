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
<h1 id="logo"><a href="<%=request.getContextPath()%>/JSP/aboutus.jsp">ABC Company <span>Retail</span></a></h1>
<nav id="nav">
<ul><%request.getSession().invalidate(); %>
		
	<li class="current"><a href="">Welcome</a></li>
	<li class="submenu"><a href="">Departments</a>
	<ul>
		<li><a href="<%=request.getContextPath() %>/CustomerController?name=Cosmetics&action=getitems">Cosmetics</a></li>
		<li><a href="<%=request.getContextPath() %>/CustomerController?name=bakery&action=getitems">Bakery</a></li>
		<li><a href="<%=request.getContextPath() %>/CustomerController?name=dairy&action=getitems">Dairy</a></li>
		<li><a href="<%=request.getContextPath() %>/CustomerController?name=deli&action=getitems">Deli Products</a></li>
		<li><a href="<%=request.getContextPath() %>/CustomerController?name=daily consumables&action=getitems">Daily Consumables</a></li>
		<li><a href="<%=request.getContextPath() %>/CustomerController?name=seafood&action=getitems">Sea Food</a></li>

		<li class="submenu"><a href="">New In Store</a>
		<ul>
			<li><a href="#">Chocolates</a></li>
			<li><a href="#">Kids Section</a></li>
			<li><a href="#">Fruits Section</a></li>
			<li><a href="#">20% Discount on dairy product</a></li>

		</ul>
		</li>
	</ul>
	</li>
	<li><a href="<%=request.getContextPath() %>/CustomerController?name=Cosmetics&action=CartViewer&customerId=0" class="button special">Cart </a></li>
	
	<li><a href="<%=request.getContextPath() %>/JSP/register.jsp" class="button special">Sign Up </a></li>
	<li><a href="<%=request.getContextPath() %>/JSP/Login1.jsp" class="button special">Login</a></li>

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

<div class="inner">



<div class="row">
<div class="6u"><section> <a href="<%=request.getContextPath() %>/CustomerController?name=Bakery&action=getitems" class="image featured"><img style="border-radius:12px;" src="<%=request.getContextPath() %>/IMAGES/bakery.jpg" alt="" /></a> <header>
<p name="Fresh BAKERY">Fresh Bakery</p>
</header> </section></div>
<div class="6u"><section> <a href="<%=request.getContextPath() %>/CustomerController?name=DELI&action=getitems"
	class="image featured"><img style="border-radius:12px;" src="<%=request.getContextPath() %>/IMAGES/deli.jpg" alt="" /></a> <header>
<p>Tasty deli Products</p>
</header> </section></div>
    
</div>
   
<div class="row">
<div class="6u"><section> <a href="<%=request.getContextPath() %>/CustomerController?name=Cosmetics&action=getitems"
	class="image featured"><img style="border-radius:12px;" src="<%=request.getContextPath() %>/IMAGES/cosmetic.jpg" alt="" /></a> <header>
<p>Cosmetics</p>
</header> </section></div>
<div class="6u"><section> <a href="<%=request.getContextPath() %>/CustomerController?name=DAIRY=&action=getitems"
	class="image featured"><img style="border-radius:12px;" src="<%=request.getContextPath() %>/IMAGES/dairy.jpg" alt="" /></a> <header>
<p>Fresh Dairy Product</p>
</header> </section></div>
</div>
<div class="row">
<div class="6u"><section> <a href="<%=request.getContextPath() %>/CustomerController?name=DAILY CONSUMABLES&action=getitems"
	class="image featured"><img style="border-radius:12px;" src="<%=request.getContextPath() %>/IMAGES/rsz_balanced-diet.jpg" alt="" /></a> <header>
<p>Daily Consumables</p>
</header> </section></div>
<div class="6u"><section> <a href="<%=request.getContextPath() %>/CustomerController?name=SEAFOOD&action=getitems"
	class="image featured"><img style="border-radius:12px;" src=" <%=request.getContextPath() %>/IMAGES/rsz_seafood.jpg" alt="" /></a> <header>
<p>Seafood</p>
</header> </section></div>
</div>
<footer class="major">
<ul class="buttons special">
	<li><a href="#" class=" button ">See More</a></li>
</ul>
</footer>

</div>

</section>



<!-- <!-- CTA -->
<div style="display:none">
<section id="cta">



</section></div>




<!------------------ Footer ------------------>
<footer id="footer">
<ul class="copyright">
	<li>&copy; ABC Retail</li>
	<li>Design: <a href="http://html5up.net">GROUP F</a></li>
</ul>

</footer>

</body>
</html>