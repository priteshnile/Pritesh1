<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
div.img {
    border: 1px solid #ccc;
}

div.img:hover {
    border: 1px solid #777;
}

div.img img {
    width: 100%;
    height: auto;
}

div.desc {
    padding: 15px;
    text-align: center;
}

* {
    box-sizing: border-box;
}

.responsive {
    padding: 0 6px;
    float: left;
    width: 24.99999%;
}

@media only screen and (max-width: 700px){
    .responsive {
        width: 49.99999%;
        margin: 6px 0;
    }
}

@media only screen and (max-width: 500px){
    .responsive {
        width: 100%;
    }
}

.clearfix:after {
    content: "";
    display: table;
    clear: both;
}




ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #40bf80;
}

li {
    float: left;
}
lr {
    float: right;
     display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a, .dropbtn {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
    background-color: 	#ff4000;
}

li.dropdown {
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}
</style>
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/main.js"></script>

<script type="text/javascript">


</script>
</head>
<body>

 
<ul>
<li>
      <img src="<c:url value='/images/shop.jpeg'/>" alt="Test Image" border="3" width="1268" height="120"/> </li>
</ul>
<div></div>
<ul id="m">
  <li class="dropdown"><a href="javascript:void(0)" class="dropbtn">Appliances</a>
    <div class="dropdown-content">
    
     <a href="${pageContext.request.contextPath}/mobile">Mobiles</a>
      <a href="${pageContext.request.contextPath}/testmobile">Test</a>
      <a href="TV">TV</a> 
           
    </div></li>
  <li class="dropdown"><a href="javascript:void(0)" class="dropbtn">Cloths</a>
    <div class="dropdown-content">
      <a href="PageController?action=men">Men</a>
      <a href="PageController?action=women">Women</a>
      
    </div></li>
  <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Foot Wear</a>
    <div class="dropdown-content">
      
      <a href="PageController?action=sports">Sports</a>
      <a href="PageController?action=formal">Formal</a>
    </div>
  </li>
  <li class="dropdown">
  <a href="javascript:void(0)" id="productlink" class="dropbtn" >Products</a>
  <div class="dropdown-content" id="a">

  </div>

   </li>

   <li>
 <a id="login" href="login" >Login</a>
  <li>
  
  <li>
  <a id="logout" href="${pageContext.request.contextPath}/logout" >Logout</a>
  </li>

   <lr>
 <a id="signin" href="user">Sign In</a>
 </lr>
  
</ul>
<br/>
<br/>

<form:form method="POST"  name="myitemform" >

<br/>
</form:form>


<div class="clearfix"></div>
  <%-- <input type="text" id="test2" value="${userNAME}" />  --%> 
 <input type="hidden" id="test" value="${id.email }" />  


</body>
</html>