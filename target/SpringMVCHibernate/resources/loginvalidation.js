$(document).ready(function(){
	$("#lemailerror").hide();
	//$("#lemailerror2").hide();
    $("#lpassworderror").hide();
   var errorstatus=false;
 /*function checkemail(){  
		//alert("Inside checkemail ");
  	   $.ajax({
  	   	type : "POST",
		contentType : "application/json",
		url: "http://localhost:8088/SpringMVCHibernate/checkemail", 
		dataType : 'json',
	
  	    success: function(list){  
  	    	
		       var email = $("#lemail").val();
		    	    for(var i = 0; i < list.length; i++)
		    	    {
		    	    	//alert(list[i]);
		    	    	
		    	    	if(email!=list[i])
		    	    	{
		    	    		
		    	    		errorstatus=true;
		    	    		 $("#lemailerror2").html("This Email is not registered.");
			    	   		  $("#lemailerror2").css("color", "red"); 
			    	   		  $("#lemailerror2").show();
		    	    	}
		    	    	else{
		    	    		
			    	   		  
			    	   		alert("Email is Registered");
			    	    	errorstatus=false;
			    	    	$("#lemailerror2").hide();
		    	    	}
		    	    	
		    	    	//var product=list[i].productname;
		    	       //plist += '<a href= "'+ list[i].productid + '">' + list[i].productname + '</a>'; // if Name is property of your Person object

		    	    
		    	      }
		    	 
		    	   
		    	   
  		    },  
  		    error: function(e){  
    		      alert("In error");  
    		      return false;
    		    }  
         });
     
 
 }*/
	$("#lemail").focusout(function(){
		   
		  checklemail();
		 // checkemail();
		  

	   });
	
	function checklemail()
	{
		//alert("Inside checklemail");
		 $("#lemail").mousedown(function(){
			   $("#lemailerror").hide(); 
			//   $("#lemailerror2").hide(); 
		   });
		  if($("#lemail").val()=='')
			  {
			  $("#lemailerror").html("Please Enter Email");
			  $("#lemailerror").css("color", "red"); 
			  $("#lemailerror").show();
			   errorstatus=true;
			  }
		  else{
			   $("#emailerror").hide();  
		  }
	}
	 $("#lpassword").focusout(function(){
		 //alert("Now need to check password ");
		 checklpassword();

	   });
	
	 function checklpassword(){
		// alert("Inside checklpassword");
		 $("#lpassword").mousedown(function(){
			   $("#lpassworderror").hide(); 
		   });
		  if($("#lpassword").val()=='')
			  {
			 // alert("password is blank");
			  $("#lpassworderror").html("Please Enter password");
			  $("#lpassworderror").css("color", "red"); 
			  $("#lpassworderror").show();
			   errorstatus=true;
			  // alert(errorstatus);
			   //return false;
			  }
		  else{
			   $("#lpassworderror").hide();  
		  } 
	 };

	  $("#lsubmit").click(function(){
			//  alert("Submit");
			  //error_status=false;
		   errorstatus=false;
			checklpassword();
		checklemail();
		//checkemail();
	
		
		 
			  if(errorstatus)
				  {
				  //alert("inside if");
				  return false;
				  }
			  else
				  {
				  //alert("In else");
				  return true;
				  }
			  
		  })
});