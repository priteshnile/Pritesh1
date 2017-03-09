$(document).ready(function(){
	$("#quantity").val(0);
	$("#msg").hide();
	$("#login").show();
	$("#signin").show();
	  // $("#notloggedin").hide();
	//**************************************Login/Logout Hiding************************************************
	
	
	var test=$("#test").val();
	//alert(test);
	console.log(test);
	//alert(test);
	if(test=='')
		{
		console.log("test mai hai kuch");
		//alert("Must show Logout");
	$("#login").show();
	$("#signin").show();
		$("#logout").hide();
		}
	else
		{
		//alert("Login must be here");
		$("#login").hide();
		$("#signin").hide();
		$("#logout").show();
		}

	$(".AddToKart").click(function(){
		//************************************Logic to check logged in or not****************************
		//alert($(".new_item").length);
		var test=$("#test").val();
		var pagename=$("#pagename").val();
		//alert(pagename);
		//alert("Inside addToKart "+test);
		console.log(test);
		//alert(test);
		if(test=='')
			{
			$.ajax({
				url: "http://localhost:8088/SpringMVCHibernate/goBackToLogin",
				type:"POST",
			 data: { 'pagename' : pagename},
				 success: function(s){  
					 //alert(s);
					 window.location.href=s;
						
		    		    },  
		    		    error: function(e){  
		    		    	//alert(JSON.stringify(r));
		      		      //alert("In error");  
		      		      
		      		    }  
			});
			//window.location.href="login";
			}
			
		else
			{			
		var itemid=$(this).attr('id');
		//var quantity=$("#quantity").val();
		//alert(quantity);
		$.ajax({
			url: "http://localhost:8088/SpringMVCHibernate/addToKart",
			type:"POST",
		 data: { 'itemid' : itemid/*,'quantity' : quantity*/},
			 success: function(msg){  
					//alert(msg);
					$("#msg").show();
	    		    },  
	    		    error: function(e){  
	    		    	//alert(JSON.stringify(r));
	      		      //alert("In error");  
	      		      
	      		    }  
		});
			}
		//alert("In AddToKart");
		//var itemid=$("#itemid").val();
		
	})

//***********************************************Show Products**********************************************
    $("#productlink").mouseenter(function(){
    	
    	   $.ajax({
    	   	type : "POST",
		contentType : "application/json",
		url: "http://localhost:8088/SpringMVCHibernate/showProducts", 
		dataType : 'json',
	
    	    success: function(list){  
    	    	//alert(JSON.stringify(list));
    	    	
    	    	$("#a").empty();
 		       var plist = '';
 		    	    for(var i = 0; i < list.length; i++)
 		    	    {
 		    	    	var product=list[i].productname;
 		    	    	
 		    	       plist += '<a href= "'+ list[i].productid + '">' + list[i].productname + '</a>'; // if Name is property of your Person object

 		    	    
 		    	      }
 		    	 
 		    	    $("#a").append(plist);
 		    	   
    		    },  
    		    error: function(e){  
      		      alert("In error");  
      		      return false;
      		    }  
           });
       
    });
	
});