//$(document).ready(function(){
	  window.fbAsyncInit = function() {
		  $("#logout").click(function(){
		    	//alert("Now logout");
		    	 FB.logout(function(){
		        	 $.ajax({
		        	  	   	type : "GET",
		        	  	  async: false,
		        	  	  //data: { 'email' : email},
		        			//contentType : "application/json",
		        			url: "http://localhost:8088/SpringMVCHibernate/logout", 
		        		//	dataType : 'json',
		        		
		        			 success: function(){  
		        			  	    
		        			      // var email = $("#email").val();
		        			    	    
		        	    	   
		        	  		    },  
		        	  		    error: function(e){  
		        	    		      alert("In error");  
		        	    		      return false;
		        	    		    }  
		        	         });
		        	     
		        	
		        	document.location.reload();});
		    })
		  
		    FB.init({
		      appId      : '252080665251426', // Set YOUR APP ID
		      channelUrl : '', // Channel File
		      status     : true, // check login status
		      cookie     : true, // enable cookies to allow the server to access the session
		      xfbml      : true  // parse XFBML
		    });
		 
		    FB.Event.subscribe('auth.authResponseChange', function(response) 
		    {
		     if (response.status === 'connected') 
		    {
		        document.getElementById("message").innerHTML +=  "<br>Connected to Facebook";
		        //SUCCESS
		 
		    }    
		    else if (response.status === 'not_authorized') 
		    {
		        document.getElementById("message").innerHTML +=  "<br>Failed to Connect";
		 
		        //FAILED
		    } else 
		    {
		        document.getElementById("message").innerHTML +=  "<br>Logged Out";
		 
		        //UNKNOWN ERROR
		    }
		    }); 
		 
		    };
		 
		    function Login()
		    {
		    	//alert("Inside Login");
		        FB.login(function(response) {
		           if (response.authResponse) 
		           {
		        	   var r="";
		                getUserInfo();
		                $("#login").hide();
		        		$("#signin").hide();
		        		$("#logout").show();
		        		//$("#test").val("huyyyg");
		        		// window.location = "http://www.google.com/";
		        		 //window.location = "http://localhost:8088/SpringMVCHibernate/";
		            } else 
		            {
		             console.log('User cancelled login or did not fully authorize.');
		            }
		         },{scope: 'email,user_photos,user_videos'});
		 
		    }
		 
		  function getUserInfo() {
		        FB.api('/me', {fields: 'name,email'},function(response) {
		        	//alert("response "+JSON.stringify(response));
		        	email = response.email; //get user email
		    	    //alert(email);
		        	
		        	 $.ajax({
		        	  	   	type : "POST",
		        	  	  async: false,
		        	  	  data: { 'email' : email},
		        			//contentType : "application/json",
		        			url: "http://localhost:8088/SpringMVCHibernate/checkemail2", 
		        		//	dataType : 'json',
		        		
		        			 success: function(s){  
		        			  	    
		        			      // var email = $("#email").val();
		        			    	   // alert("In success);
		        			    	 
		        	    	   
		        	  		    },  
		        	  		    error: function(e){  
		        	    		      //alert("In error");  
		        	    		      return false;
		        	    		    }  
		        	         });
		        	     
		        	
		   /*  var str="<b>Name</b> : "+response.name+"<br>";
		          str +="<b>Link: </b>"+response.link+"<br>";
		          str +="<b>Username:</b> "+response.username+"<br>";
		          str +="<b>id: </b>"+response.id+"<br>";
		          str +="<b>Email:</b> "+response.email+"<br>";
		          str +="<input type='button' value='Get Photo' onclick='getPhoto();'/>";
		          str +="<input type='button' value='Logout' onclick='Logout();'/>";
		          document.getElementById("status").innerHTML=str;*/
		 
		    });
		    }
		    function getPhoto()
		    {
		      FB.api('/me/picture?type=normal', function(response) {
		 
		          var str="<br/><b>Pic</b> : <img src='"+response.data.url+"'/>";
		          document.getElementById("status").innerHTML+=str;
		 
		    });
		 
		    }
		    function Logout()
		    {
		        FB.logout(function(){
		        	 $.ajax({
		        	  	   	type : "GET",
		        	  	  async: false,
		        	  	  //data: { 'email' : email},
		        			//contentType : "application/json",
		        			url: "http://localhost:8088/SpringMVCHibernate/logout", 
		        		//	dataType : 'json',
		        		
		        			 success: function(){  
		        			  	    
		        			      // var email = $("#email").val();
		        			    	    
		        	    	   
		        	  		    },  
		        	  		    error: function(e){  
		        	    		      alert("In error");  
		        	    		      return false;
		        	    		    }  
		        	         });
		        	     
		        	
		        	document.location.reload();});
		    }
		   
		 
		  // Load the SDK asynchronously
		  (function(d){
		     var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
		     if (d.getElementById(id)) {return;}
		     js = d.createElement('script'); js.id = id; js.async = true;
		     js.src = "//connect.facebook.net/en_US/all.js";
		     ref.parentNode.insertBefore(js, ref);
		   }(document));
		 
	//});