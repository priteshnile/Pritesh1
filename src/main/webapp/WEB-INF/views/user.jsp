<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Sign In Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
	<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/validation.js"></script>

<input type="hidden" id="hdnSession" data-value="@Request.RequestContext.HttpContext.Session["id"]" />
</head>
<body>
<jsp:include page="my-header.jsp"></jsp:include>

    <h1>Registration Form</h1>  
           <form:form method="POST" action="${pageContext.request.contextPath}/save" name="myform" >    
            <c:if test="${param.success.success eq true }">
            <div class="alert alert-success"> Registration Successful</div>
            </c:if>
            <table >    
            <tr>  
            <td></td>    
             <td><form:hidden  path="userid" /></td>  
             </tr>   
             <tr>    
              <td> FirstName : </td>   
              <td><form:input id="firstname" path="firstName"/></td><td><p  id="firstnameerror"></p></td>  
             </tr>    
             <tr>    
              <td>Last Name :</td>    
              <td><form:input id="lastname" path="lastName" /></td> <td><p id="lastnameerror"></p></td>   
             </tr> 
             
             <tr>    
              <td>Email :</td>    
              <td><form:input id="email" path="email" /></td>   <td><p id="emailerror"></p><p id="emailerror2"></p><p id="validemail"></p></td>   
             </tr>   
               <tr>    
              <td>Phone Number :</td>    
              <td><form:input id="phone_no" path="phone_no" /></td>   <td><p id="phone_noerror"><p id="phone_noerror2"></p></td>   
             </tr>
               <tr>   
                
              <td> 
         <%--    <form:radiobutton path="gender" value="M" />Male <form:radiobutton
					path="gender" value="F" />Female</td> --%>
              
            Gender: <input id="m" type="radio" name="gender" value="Male">Male
               <input id="f" type="radio" name="gender" value="Female">Female
               <div id="msg" style="color:#FF0000"></div>
               </td>    
             </tr>
               <tr>    
              <td>City: <select name="city" id="slectboxid">
 <option value="Mumbai">Mumbai</option>
<option value="Delhi">Delhi</option>
<option value="Kolkata">Kolkata</option>
<option value="Chennai">Chennai</option>
<option value="Hyderabad">Hyderabad</option>
<option value="Pune">Pune</option>
<option value="Banglore">Banglore</option>
</select></td>    
              
             </tr>
               <tr>    
              <td>Password :</td>    
              <td><input id="password" type="password" path="password" name="password"/></td>   <td><p id="passworderror"></p><p id="passworderror2"></p></td>   
             </tr>
             <tr>    
              <td>Re-enter Password :</td>    
              <td><input id="password2" type="text" "password2"/></td>   <td><p id="password2error"></p><p id="password2error2"></p></td>   
             </tr>
             <tr>    
              <td> </td>    
              <td><input id="submit" type="submit" value="Submit" /></td>    
             </tr>    
            </table>    
           </form:form> 
<jsp:include page="my-footer.jsp"></jsp:include>
</body>
</html>
