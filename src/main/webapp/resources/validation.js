$(document).ready(function(){
	
   $("#firstnameerror").hide();
   $("#lastnameerror").hide();
   $("#emailerror").hide();
   $("#phone_noerror").hide();
   $("#passworderror").hide();
   $("#password2error").hide();
   $("#password2error2").hide();
   
   var errorstatus=false;
   
   //*****************************************valid email**************************************************
   function checkemail2(){
		alert("Inside checkemail2");
		 var email = $("#email").val();
  	   $.ajax({
  	   	type : "POST",
  	  async: false,
  	  data: { 'email' : email},
		//contentType : "application/json",
		url: "http://localhost:8088/SpringMVCHibernate/checkemail", 
	//	dataType : 'json',
	
  	    success: function(s){  
  	    
		      // var email = $("#email").val();
		    	    
		    	    	if(s=='y')
		    	    	{
		    	    		errorstatus=true;
		    	    		alert("It should go to if "+errorstatus);
		    	    	  $("#emailerror").html("Email is not available");
		    	   		  $("#emailerror").css("color", "red"); 
		    	   		  $("#emailerror").show();
		    	    	}
		    	    	else{
		    	    		 $("#validemail").hide();
		    	    	}
    	   
  		    },  
  		    error: function(e){  
    		      alert("In error");  
    		      return false;
    		    }  
         });
     
   }
   
   //******************************************First Name***************************************************
 $("#firstname").focusout(function(){
	   
	   $("#firstname").keypress(function(){
		   $("#firstnameerror").hide();  
	   });
	  if($("#firstname").val()=='')
		  {
		  $("#firstnameerror").html("First Name can't be blank");
		  $("#firstnameerror").css("color", "red"); 
		  $("#firstnameerror").show();
		   errorstatus=true;
		  }
	  else{
		   $("#firstnameerror").hide();  
	  }

   });
   function  check_firstname(){
	 
	   if($("#firstname").val()=='')
		  {
		  // alert("In if lastcheck");
		   $("#firstnameerror").html("First Name can't be blank");
			  $("#firstnameerror").css("color", "red"); 
		   $("#firstnameerror").show();
		   errorstatus=true;
		  }
	  else{
		   $("#firstnameerror").hide();  
	  }
   }
   
   //********************************************Last Name*************************************************
   $("#lastname").focusout(function(){
	   
	   $("#lastname").keypress(function(){
		   $("#lastnameerror").hide();  
	   });
	  if($("#lastname").val()=='')
		  {
		  $("#lastnameerror").html("Last Name can't be blank");
		  $("#lastnameerror").css("color", "red"); 
		  $("#lastnameerror").show();
		   errorstatus=true;
		  }
	  else{
		   $("#lastnameerror").hide();  
	  }

   });
   function  check_lastname(){
	 
	   if($("#lastname").val()=='')
		  {
		  // alert("In if lastcheck");
		   $("#lastnameerror").html("Last Name can't be blank");
			  $("#lastnameerror").css("color", "red"); 
		   $("#lastnameerror").show();
		   errorstatus=true;
		  }
	  else{
		   $("#lastnameerror").hide();  
	  }
   }
   
 //*************************************************Email************************************************** 
   
   $("#email").focusout(function(){
	  
	   check_email();
	   checkemail2();
	   $("#email").keypress(function(){
		   $("#emailerror").hide(); 
		   $("#emailerror2").hide(); 
	   });
	  if($("#email").val()=='')
		  {
		  $("#emailerror").html("Email can't be blank");
		  $("#emailerror").css("color", "red"); 
		  $("#emailerror").show();
		   errorstatus=true;
		  }
	  else{
		   $("#emailerror").hide();  
	  }

   });
   
  
  
  
   function check_email(){
	 
	   var pattern = new RegExp(/^[+a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i);
	   if(pattern.test( $("#email").val()))
		   {
		   $("#emailerror2").hide(); 
		   }
	   else
		   {
		   $("#emailerror2").html("Email is not valid");
			  $("#emailerror2").css("color", "red"); 
			  $("#emailerror2").show();
			   errorstatus=true;
		   }
   }
   //*******************************************Phone_no***************************************************
   $("#phone_no").focusout(function(){
	 
	   check_phone_no();
	   $("#phone_no").keypress(function(){
		   $("#phone_noerror").hide(); 
		   $("#phone_noerror2").hide();
	   });
	  if($("#phone_no").val()=='')
		  {
		  $("#phone_noerror").html("Phone Number can't be blank");
		  $("#phone_noerror").css("color", "red"); 
		  $("#phone_noerror").show();
		   errorstatus=true;
		  }
	  else{
		   $("#phone_noerror").hide();  
	  }

   });
   function check_phone_no(){
	   var filter = new RegExp(/^\d{10}$/);
	   
	   	    if (filter.test($("#phone_no").val())) {	  
	   	     $("#phone_noerror2").hide();  
	   	    }	  
	   	    else {	   
	   	     $("#phone_noerror2").html("Phone Number is not valid");
			  $("#phone_noerror2").css("color", "red"); 
			  $("#phone_noerror2").show();
			  errorstatus=true;
	   	    }
	  
   }
   
   //*********************************************Password************************************************
  $("#password").focusout(function(){
	  check_password();
	
	   $("#password").keypress(function(){
		   $("#passworderror").hide(); 
		   $("#passworderror2").hide();
	   });
	  if($("#password").val()=='')
		  {
		  $("#passworderror").html("Password can't be blank");
		  $("#passworderror").css("color", "red"); 
		  $("#passworderror").show();
		   errorstatus=true;
		  }
	  else{
		   $("#passworderror").hide();  
	  }

   });
  function check_password(){
	   
	   	    if ($("#password").val().length<8 ||$("#password").val().length>20) {	
	   	     $("#passworderror2").html("Password length must be between 8 to 20");
			  $("#passworderror2").css("color", "red"); 
	   	     $("#passworderror2").show(); 
	   	   errorstatus=true;
	   	    }	  
	   	    else {	   
	   	
			  $("#passworderror2").hide();
	   	    }
	  
  }

  //*********************************************Password2*************************************************
  $("#password2").focusout(function(){
	 
	   $("#password2").keypress(function(){
		   $("#password2error").hide();  
		   $("#password2error2").hide();
	   });
	  if($("#password2").val()=='')
		  {
		  $("#password2error").html("Re-entered Password can't be blank");
		  $("#password2error").css("color", "red"); 
		  $("#password2error").show();
		  var errorstatus=true;
		  }
	  else{
		   $("#password2error").hide(); 
		   check_password2();
	  }

   });
  function check_password2(){
	
	   	   if (!(($("#password2").val())==($("#password").val()))) {
	   	  alert("Not matching ");
	   		 errorstatus=true;
	   	     $("#password2error2").html("Password and Re-entered password does not match");
			  $("#password2error2").css("color", "red"); 			  
	   	     $("#password2error2").show();   
	   	  
	   	 //  alert(errorstatus);
	   	  
	   	    }	  
	   	    else {	   
	   	
			  $("#password2error2").hide();
	   	    }
	  
  }
  
  //*********************************************SUBMIT Validation*****************************************
  
  function check_allforblank(){
	  if(($("#firstname").val()=='')||($("#lastname").val()=='')||($("#email").val()=='')||($("#phone_no").val()=='')||($("#password").val()=='')||($("#password2").val()==''))
		  {
		  errorstatus=true;
		  }
	  else
		  {
		  errorstatus=false;
		  }
	  
  }
  
  $("#submit").click(function(){
	//  alert("Submit");
	  //errorstatus=false;
	  check_email();
	  check_phone_no();
	  check_password();
	  check_password2();
	  check_firstname();
	  check_lastname();
	  check_allforblank();
	  checkemail2();
	 
	  $("#password").keypress(function(){
		   $("#passworderror").hide(); 
		   $("#passworderror2").hide();
	   });
	  $("#phone_no").keypress(function(){
		   $("#phone_noerror").hide(); 
		   $("#phone_noerror2").hide();
	   });
	  $("#email").keypress(function(){
		   $("#emailerror").hide(); 
		   $("#emailerror2").hide(); 
	   });
	  $("#lastname").keypress(function(){
		   $("#lastnameerror").hide();  
	   });
	  $("#firstname").keypress(function(){
		   $("#firstnameerror").hide();  
	   });
	  
	  if(errorstatus)
		  {
		  alert("In if ");
		  return false;
		  }
	  else
		  {
		  alert("In else ");
		  return true;
		  }
	  
  })
  
});