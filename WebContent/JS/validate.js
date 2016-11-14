

//-------------------------------------Add Department validation----------------------------
function validate(){
	var email=document.getElementById("email").value;
	var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	if(reg.test(email)==false)
	{
		alert("Please enter valid email id");
	return false;
	}
	
	 var emailrepeat=document.getElementById("emailrepeat").value;
		
		if((emailrepeat!=email)||emailrepeat=="")
		{
			alert("Your Email id did not match");
		return false;
		}  
	
    var pass = /^([A-Za-z0-9_\-\.\@]{6,99})+$/;
    var password=document.getElementById("pass").value;
    if(password == "" || pass.test(password)==false){
		alert("Please enter a valid password. \nYour password must contain atleast 6characters.");
		return false;
    }
   
    var passwordrepeat=document.getElementById("passrepeat").value;
    if(passwordrepeat == "" || passwordrepeat!=password){
		alert(" Password did not match \n Please enter a valid password.");
		return false;
    }
    
    
    var name = /^([A-Za-z])+$/;
    var nameField=document.getElementById("name").value;
    if(nameField == null||name.test(nameField)==false){
		alert("Your Name field can not be left blank and it should contain only character");
		return false;
    }
    
    var gender = document.register.gender;
    var count = 0;
    for(var x=0;x<gender.length;x++)
    	{
    		if(gender[x].checked)
    			count++;
    	}
    if(count==0)
    	{
    		alert("Please select gender");
    		return false;
    	}

    /*
     * Validation for date of birth is left.
     */
    
    
    var c=document.register.phone.value;
	if(c=="")
	{
		alert("Please enter contanct number");
	return false;
	}
	if(isNaN(c))
	{
		alert("Please enter contact number in number format");
	return false;
	}
    
	var city = /^([A-Za-z])+$/;
    var cityField=document.getElementById("city").value;
    if(cityField == null||city.test(cityField)==false){
		alert("Your city field can not be left blank and it should contain only character");
		return false;
    }
	
    var state = /^([A-Za-z])+$/;
    var stateField=document.getElementById("state").value;
    if(stateField == null||state.test(stateField)==false){
		alert("Your state field can not be left blank and it should contain only character");
		return false;
    }
	
    
    var zip=document.register.zip.value;
	if(zip==""||zip.length!=5)
	{
		alert("Please enter valid zip Code");
	return false;
	}
	if(isNaN(zip))
	{
		alert("Please enter zip code in number format");
	return false;
	}
    
	if(!this.register.agreement.checked)
	{
	    alert('You must agree to the terms first.');
	    return false;
	}

    return true;
}

function validatedepartment()
{
	var departmentname=document.addDepartment.departmentname.value;
	if(departmentname=="")
	{
		alert("Please enter department name");
		document.getElementById('departmentname').focus();
		return false;
	}
	if(departmentname.length>30 || !departmentname.match(/[a-z]/i))
	{
		alert("Please enter valid department name of max length 30 characters.\n Only Alphabets are allowed .");
		document.getElementById('departmentname').value = "";
		document.getElementById('departmentname').focus();
		return false;
	}

	return true;
}


//--------------------------------- Update Department validation---------------------------------


function validateUpdateDepartment()
{
	var departmentname=document.udpatedepartmentForm.departmentname.value;
	if(departmentname=="")
	{
		alert("Please enter department name");
		document.getElementById('departmentname').focus();
		return false;
	}
	if(departmentname.length>30 || !departmentname.match(/[a-z]/i))
	{
		alert("Please enter valid department name of max length 30 characters.\n Only Alphabets are allowed .");
		document.getElementById('departmentname').value = "";
		document.getElementById('departmentname').focus();
		return false;
	}
	return true;
}


//--------------------------------- Add Items validation---------------------------------


function validateAddItem()
{
	var itemname=document.additems.itemname.value;
	if(itemname=="")
	{
		alert("Please enter Item Name");
		document.getElementById('itemname').value = "";
		document.getElementById('itemname').focus();
		return false;
	}
	if(itemname.length>30 || !itemname.match(/[a-z]/i))
	{
		alert("Please enter valid Item Name of max length 30 characters.\nOnly Alphabets are allowed.");
		document.getElementById('itemname').value = "";
		document.getElementById('itemname').focus();
		return false;
	}
	var departmentid=document.additems.departmentid.value;
	if(departmentid=="") 
	{
		alert("Please enter Department Id");
		document.getElementById('departmentid').value = "";
		document.getElementById('departmentid').focus();
		return false;
	}
	if(isNaN(departmentid))
	{
		alert("Please enter numeric value for departmentid");
		document.getElementById('departmentid').value = "";
		document.getElementById('departmentid').focus();
		return false;
	}
	var itemprice=document.additems.price.value;
	if(itemprice=="")
	{
		alert("Please enter Item Price");
		document.getElementById('price').value = "";
		document.getElementById('price').focus();
		return false;	
	}
	if(isNaN(itemprice))
	{
		alert("Please enter numeric value for Item Price");
		document.getElementById('price').value = "";
		document.getElementById('price').focus();
		return false;
	}
	var quantity=document.additems.quantity.value;
	if(quantity=="")
	{
		alert("Please enter Quantity");
		document.getElementById('quantity').value = "";
		document.getElementById('quantity').focus();
		return false;	
	}
	if(isNaN(quantity))
	{
		alert("Please enter numeric value for Quantity");
		document.getElementById('quantity').value = "";
		document.getElementById('quantity').focus();
		return false;
	}
	return true;
}

//--------------------------------- Update Items validation---------------------------------


function validateUpdateItem()
{
	var itemname=document.updateitems.itemname.value;
	if(itemname=="")
	{
		alert("Please enter Item Name");
		document.getElementById('itemname').value = "";
		document.getElementById('itemname').focus();
		return false;
	}
	if(itemname.length>30 || !itemname.match(/[a-z]/i))
	{
		alert("Please enter valid Item Name of max length 30 characters,\nOnly Alphabets are allowed.");
		document.getElementById('itemname').value = "";
		document.getElementById('itemname').focus();
		return false;
	}
	var departmentid=document.updateitems.departmentid.value;
	if(departmentid=="") 
	{
		alert("Please enter Department Id");
		document.getElementById('departmentid').value = "";
		document.getElementById('departmentid').focus();
		return false;
	}
	if(isNaN(departmentid))
	{
		alert("Please enter numeric value for departmentid");
		document.getElementById('departmentid').value = "";
		document.getElementById('departmentid').focus();
		return false;
	}
	var itemprice=document.updateitems.price.value;
	if(itemprice=="")
	{
		alert("Please enter Item Price");
		document.getElementById('price').value = "";
		document.getElementById('price').focus();
		return false;	
	}
	if(isNaN(itemprice))
	{
		alert("Please enter numeric value for Item Price");
		document.getElementById('price').value = "";
		document.getElementById('price').focus();
		return false;
	}
	var quantity=document.updateitems.quantity.value;
	if(quantity=="")
	{
		alert("Please enter Quantity");
		document.getElementById('quantity').value = "";
		document.getElementById('quantity').focus();
		return false;	
	}
	if(isNaN(quantity))
	{
		alert("Please enter numeric value for Quantity");
		document.getElementById('quantity').value = "";
		document.getElementById('quantity').focus();
		return false;
	}
	return true;
}

//-------------------------------------Add Outlet------------------------------------

function validateAddOutlet()
{
	var address=document.addoutlet.address.value;
	if(address=="")
	{
		alert("please Enter the address");
		document.addoutlet.address.focus();
		return false;
	}
	if(address.length<5 || (address.length>100))
	{
		alert("Please enter Address between 5 to 100 character");
		document.getElementById('address').value = "";
		document.getElementById('address').focus();
		return false;
	}
	var city=document.addoutlet.city.value;
	if(city=="") 
	{
		alert("Please enter City");
		document.getElementById('city').value = "";
		document.getElementById('city').focus();
		return false;
	}
	if(!isNaN(city) || (city.length>20))
	{
		alert("Please enter valid City Name of length 20");
		document.getElementById('city').value = "";
		document.getElementById('city').focus();
		return false;
	}
	var state=document.addoutlet.state.value;
	if(state=="")
	{
		alert("Please enter State");
		document.getElementById('state').value = "";
		document.getElementById('state').focus();
		return false;	
	}
	if(!isNaN(state) || (state.length>20))
	{
		alert("Please enter valid state of length 20.\n Only numbers allowed.");
		document.getElementById('state').value = "";
		document.getElementById('state').focus();
		return false;
	}
	var zipcode=document.addoutlet.zipcode.value;
	if(zipcode=="")
	{
		alert("Please enter Zipcode");
		document.getElementById('zipcode').value = "";
		document.getElementById('zipcode').focus();
		return false;	
	}
	if(isNaN(zipcode) || ((zipcode.length<5)||(zipcode.length>=6)))
	{
		alert("Please enter a valid Zipcode of length 5");
		document.getElementById('zipcode').value = "";
		document.getElementById('zipcode').focus();
		return false;
	}
	return true;
}

//------------------------------------- Outlet------------------------------------


function validateUpdateOutlet()
{
	var address=document.updateoutlet.address.value;
	if(address=="")
	{
		alert("please Enter the address");
		document.addoutlet.address.focus();
		return false;
	}
	if(address.length<5 || (address.length>100))
	{
		alert("Please enter Address between 5 to 100 character");
		document.getElementById('address').value = "";
		document.getElementById('address').focus();
		return false;
	}
	var city=document.updateoutlet.city.value;
	if(city=="") 
	{
		alert("Please enter City");
		document.getElementById('city').value = "";
		document.getElementById('city').focus();
		return false;
	}
	if(!isNaN(city) || (city.length>20))
	{
		alert("Please enter valid City Name of length 20");
		document.getElementById('city').value = "";
		document.getElementById('city').focus();
		return false;
	}
	var state=document.updateoutlet.state.value;
	if(state=="")
	{
		alert("Please enter State");
		document.getElementById('state').value = "";
		document.getElementById('state').focus();
		return false;	
	}
	if(!isNaN(state) || (state.length>20))
	{
		alert("Please enter valid state of length 20");
		document.getElementById('state').value = "";
		document.getElementById('state').focus();
		return false;
	}
	var zipcode=document.updateoutlet.zipcode.value;
	if(zipcode=="")
	{
		alert("Please enter Zipcode");
		document.getElementById('zipcode').value = "";
		document.getElementById('zipcode').focus();
		return false;	
	}
	if(isNaN(zipcode) || ((zipcode.length<5)||(zipcode.length>=6)))
	{
		alert("Please enter a valid Zipcode of length 5");
		document.getElementById('zipcode').value = "";
		document.getElementById('zipcode').focus();
		return false;
	}
	return true;
}
localStorage.setItem("count","0");
//-------------------------------------Cart view------------------------------------
function validateCartView()
{
	var count=0;
	

//	alert("into crtview");
	var quant=/^[0-9][0-9]*([\.][0-9]+)?$/;
	var i=0;
	var confirm=document.getElementsByName("itemcart");
	

	for(i=0;i<confirm.length;i++)
	{
		var quantity=document.getElementById("quantity"+i).value;

		if(confirm[i].checked )
		{
			count++;
			localStorage.count=count;
			/*alert(localStorage.count);*/
			if(!quant.test(quantity)){
				
			
			/*alert("into else");*/
			/*for(var i=0;i<confirm.length ;i++)
			{*/
				//alert(i+"::"+confirm.length+"::");
				
				//alert(i+"::"+confirm.length+"::");
				/*if()
				{
					*/alert("please provide the quantity");
					document.getElementById('quantity'+i).value = "";
					document.getElementById('quantity'+i).focus();
					
			return false;

			}

			

		}
	}
	
		if(localStorage.count=="0"){
			alert("please check the required item field");
			return false;
		}

		else{
			alert(locqalStorage.count);
			localStorage.setItem("count", "0");
			
			return true;
		}
}	



function deleteitem(){
	alert("into delete");
	var answer=confirm("do you want to delete?");
	if(answer){
		return true;
	}
	else{ return false;}
	
	
}





