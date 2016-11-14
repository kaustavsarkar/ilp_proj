
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>

<title>Customer Registration Form</title>
<style>
.but{font-family: arial;font-size:24px}
.dat{font-family: arial;font-size:18px}
    .shadow{font-family:Arial;font-size:12;overflow:auto;box-shadow: 3px 3px 5px } 

.round{font-family:Arial;font-size:12;overflow:auto;-moz-border-radius: 4px; -webkit-border-radius: 4px;-khtml-border-radius: 4px;border-radius: 4px;border: solid 1px #6CB9FF; text-decoration:none;} 

.round1{font-family:Arial;font-size:12;overflow:auto;-moz-border-radius: 20px; -webkit-border-radius: 20px;-khtml-border-radius: 20px;border-radius: 20px;border: solid 1px #6CB9FF; text-decoration:none;}
        .normal{height:50px;width:auto;}
        .big{height:380px;width:300px;}
        
</style>
 <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <!-- Load jQuery UI Main JS  -->
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    
    <!-- Load SCRIPT.JS which will create datepicker for input field  -->
    <script src="script.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/JS/script.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/JS/DatePicker.js">
	</script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/JS/Date.js">
	</script>
	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css"
	href="<%= request.getContextPath() %>/CSS/register.css" />
</head>
<body >

	<div id="test"  >

		<form name="register" action="" class="register">
			<h1>Registration</h1>
			<fieldset class="row1">
				<legend>Account Details </legend>
				<p>
					<label> Email <span id="inline">*</span>
					</label> <input type="text" /> <label>Repeat email <span
						id="inline">*</span>
					</label> <input type="text" />
				</p>
				<p>
					<label>Password <span id="inline">*</span>
					</label> <input type="password" /> <label>Repeat Password <span
						id="inline">*</span>
					</label> <input type="password" /> <label class="obinfo"> <span
						id="inline">*</span> obligatory fields
					</label>
				</p>
			</fieldset>
			<fieldset class="row2">
				<legend>Personal Details </legend>
				<p>
					<label>Name <span id="inline">*</span>
					</label> <input type="text" class="long" />
				</p>
				<p>
					<label>Gender <span id="inline">*</span>
					</label> <input type="radio" value="male" name="gender"/>
					 <label class="gender">Male</label>
						 <input type="radio" value="female"	name="gender"/> 
						<label class="gender">Female</label>
				</p>
				<p>
					<label>Birth date <span id="inline">*</span>
					</label><input type="date" name="date" id="datepicker" /></p>
				<p>
					<label>Phone <span id="inline">*</span>
					</label> <input type="text" maxlength="10" />
				</p>
				<p>
					<label class="optional">Street </label> <input type="text"
						class="long" />
				</p>
				<p>
					<label>City <span id="inline">*</span>
					</label> <input type="text" class="long" />
				</p>
				<p>
					<label>State <span id="inline">*</span>
					</label> <input type="text" maxlength="10" />
				</p>
				<p>
					<label>Zip Code <span id="inline">*</span>
					</label> <input type="text" class="long" />
				</p>
				<%-- 
                <p>
                    <label>Country <span id="inline" >*</span> 
                    </label>
                    <select>
                        <option>
                        </option>
                        <option value="1">United States
                        </option>
                    </select>
                </p> 
                
                <p>
                    <label class="optional">Website
                    </label>
                    <input class="long" type="text" value="http://"/>

                </p>
                ---%>
			</fieldset>
			
				 <!-- <select class="date">
						<option value="1">01</option>
						<option value="2">02</option>
						<option value="3">03</option>
						<option value="4">04</option>
						<option value="5">05</option>
						<option value="6">06</option>
						<option value="7">07</option>
						<option value="8">08</option>
						<option value="9">09</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>
						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
						<option value="31">31</option>
					</select> <select>
						<option value="1">January</option>
						<option value="2">February</option>
						<option value="3">March</option>
						<option value="4">April</option>
						<option value="5">May</option>
						<option value="6">June</option>
						<option value="7">July</option>
						<option value="8">August</option>
						<option value="9">September</option>
						<option value="10">October</option>
						<option value="11">November</option>
						<option value="12">December</option>
					</select> <input class="year" type="text" size="4" maxlength="4" />e.g 1976 -->
			

		
			<fieldset class="row4">
				
				<legend>Terms and Mailing </legend>
				<table width="770px"><tr><td>
				
				<p class="agreement">
					<input type="checkbox" value="" /> <label> <span
						id="inline">*</span> I accept the <a href="#">Terms and
							Conditions</a></label>
				</p>
				<p class="agreement">
					<input type="checkbox" value="" /> <label> &nbsp;&nbsp; I
						want to receive personalized offers by your site</label>
				</p>
				
			</td><td style="text-align:left" align="left">
				<button class="button special">Register &raquo;</button></td></tr></table>
			
			</fieldset>
			
		</form>
	</div>
	<%-- 
<center>
	<div id="img" style="display: block" class="login">
		<h2>Log in</h2>
		<br></br>
		<form name="login" action="">
			
			<p>
				<label> User Name <span id="inline">*</span>
				</label>
				 <input type="text" name="username" /> 
				<br></br> 
				<label>&nbsp;&nbsp;Password <span id="inline">*</span>
				</label> <input type="password" name="password" />
			</p>
			<br></br>
			<input type="submit" value="Login" name="login" ></input>
			</form>
			<br></br> OR
			<br></br>
			<button name="register" onclick="validate()">Register</button>
		<br></br>
	

	</div>
</center>
--%>
<!-- <footer id="footer">

<ul class="icons">
	<li><a href="#" class="icon circle fa-twitter"><span
		class="label">Twitter</span></a></li>
	<li><a href="#" class="icon circle fa-facebook"><span
		class="label">Facebook</span></a></li>
	<li><a href="https://google.com/"
		class="icon circle fa-google-plus"><span class="label">Google+</span></a></li>
	<li><a href="#" class="icon circle fa-github"><span
		class="label">Github</span></a></li>
	<li><a href="#" class="icon circle fa-dribbble"><span
		class="label">Dribbble</span></a></li>
</ul>

<ul class="copyright">
	<li>&copy; ABC Retail</li>
	<li>Design: <a href="http://html5up.net">GROUP F</a></li>
</ul>

</footer> -->

</body>
</html>





