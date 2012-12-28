<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        </div>
    </div>
    
	<div class="bottomBar"><div class="bottomBarWhite"></div></div>
    
    </div>
    
    
<script>

function validateForm(form){
	if(
			isEmpty(form.firstName.value) || 
			isEmpty(form.lastName.value) || 
			isEmpty(form.username.value) || 
			isEmpty(form.password1.value) ||
			isEmpty(form.password2.value) ||
			isEmpty(form.email.value) || 
			isEmpty(form.creditNum.value) ||
			isEmpty(form.productID.value) || 
			isEmpty(form.premiumSignup.value) ||
			isEmpty(form.timeUnits.options[form.timeUnits.selectedIndex].value) || 
			isEmpty(form.monthsOrYears.options[form.monthsOrYears.selectedIndex].value) || 
			isEmpty(form.creditExpMonth.options[form.creditExpMonth.selectedIndex].value) ||
			isEmpty(form.creditExpYear.options[form.creditExpYear.selectedIndex].value) 
	){
		alert("Please complete all fields before submitting"); 
		return false; 
	}
	if(form.password1.value != form.password2.value){
		alert("Please make sure your passwords match"); 
		return false; 
	}
	
	return true; 

}


function isEmpty(input){
	if(input=="" || input == null){
		return true; 
	}
	return false; 
}
</script>

</body>
</html>