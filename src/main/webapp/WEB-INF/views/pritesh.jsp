<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="${pageContext.request.contextPath}/resources/social.js"></script>
<title>Login with Google Account using JavaScript by CodexWorld</title>
<meta name="google-signin-client_id" content="YOUR_CLIENT_ID.apps.googleusercontent.com">
<script src="jquery.min.js"></script>
<script src="https://apis.google.com/js/client:platform.js?onload=renderButton" async defer></script>
<style>
.profile{
    border: 3px solid #B7B7B7;
    padding: 10px;
    margin-top: 10px;
    width: 350px;
    background-color: #F7F7F7;
    height: 160px;
}
.profile p{margin: 0px 0px 10px 0px;}
.head{margin-bottom: 10px;}
.head a{float: right;}
.profile img{width: 100px;float: left;margin: 0px 10px 10px 0px;}
.proDetails{float: left;}
</style>
</head>
<body>

<script type="text/javascript">
(function() {
    var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
    po.src = 'https://apis.google.com/js/client.js?onload=onLoadCallback';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
  })();


 </script>
<!-- HTML for render Google Sign-In button -->
<div id="gSignIn"></div>
<!-- HTML for displaying user details -->
<div class="userContent"></div>
<input type="button"  value="Login" onclick="login()" />
<input type="button"  value="Logout" onclick="logout()" />
<div class="g-signin2" data-onsuccess="onSignIn"></div>


</body>
</html>