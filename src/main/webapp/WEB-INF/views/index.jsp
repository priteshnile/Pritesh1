<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/resources/social.js"></script>
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/sociallogin.js"></script>
</head>
<body>
<jsp:include page="my-header.jsp"></jsp:include>
<div id="fb-root"></div>

 <div align="left">

 
<div id="status">
  <br/>
<img src="http://hayageek.com/examples/oauth/facebook/oauth-javascript/LoginWithFacebook.png" style="cursor:pointer;" width="180" height="40" onclick="Login()"/>
</div>
</div> 

&nbsp; &nbsp; &nbsp; &nbsp; 
<input type="button"  value="Gmail Login" onclick="login()" />
<!-- <input type="button"  value="Logout" onclick="logout()" /> -->
 <div id="profile"></div>
<script type="text/javascript">
(function() {
    var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
    po.src = 'https://apis.google.com/js/client.js?onload=onLoadCallback';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
  })();


 </script>

<img src="<c:url value='/images/shopbanner.jpeg'/>" alt="Test Image" border="3" width="1268" height="320"/>
<br><br>
<div class="clearfix"></div>
<jsp:include page="my-footer.jsp"></jsp:include>

</body>
</html>