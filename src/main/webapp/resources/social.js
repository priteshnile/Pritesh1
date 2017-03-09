function logout()
{
	alert("In logout");
    gapi.auth.signOut();
    location.reload();
}
function login() 
{ var email = '';
  var myParams = {
    'clientid' : '282726217956-5bs9bg4emeof95a2p87s0k9hjoshm404.apps.googleusercontent.com',
    'cookiepolicy' : 'single_host_origin',
    'callback' : 'loginCallback',
    'approvalprompt':'force',
    'scope' : 'https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/plus.profile.emails.read'
  };
  gapi.auth.signIn(myParams);
  $("#login").hide();
	$("#signin").hide();
	$("#logout").show();
  
   
}
 
function loginCallback(result)
{
    if(result['status']['signed_in'])
    {
        var request = gapi.client.plus.people.get(
        {
            'userId': 'me'
        });
        request.execute(function (resp)
        {
           
            if(resp['emails'])
            {
                for(i = 0; i < resp['emails'].length; i++)
                {
                    if(resp['emails'][i]['type'] == 'account')
                    {
                        email = resp['emails'][i]['value'];
                    }
                }
            }
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
 
            var str = "Name:" + resp['displayName'] + "<br>";
            str += "Image:" + resp['image']['url'] + "<br>";
            str += "<img src='" + resp['image']['url'] + "' /><br>";
 
            str += "URL:" + resp['url'] + "<br>";
            str += "Email:" + email + "<br>";
            document.getElementById("profile").innerHTML = str;
        });
 
    }
 
}
function onLoadCallback()
{
    gapi.client.setApiKey('AIzaSyCte91hPYmGeba3Sx8ulMqRufU4iRM8268');
    gapi.client.load('plus', 'v1',function(){});
}
 

      