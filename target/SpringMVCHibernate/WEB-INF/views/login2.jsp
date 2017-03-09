<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/loginvalidation.js"></script>

</head>
<body>
<jsp:include page="my-header.jsp"></jsp:include>
<form:form method="POST" action="${pageContext.request.contextPath}/authenticate" name="myform" >    
            <table >    
            <tr>  
            <td></td>    
             <td><form:hidden id="userid"  path="userid" /></td>  
                
             </tr>   
            <tr>
              <td>Email :</td>    
              <td><form:input path="email" id="lemail"  /></td> <td><p id="lemailerror"></p></td> 
             </tr>   

               <tr>    
              <td>Password :</td>    
              <td><form:input path="password" id="lpassword" name="password"/></td> <td><p id="lpassworderror"></p></td> 
             </tr>
             
            <tr>   
              <td><input id="lsubmit" type="submit" value="Submit" /></td>    
             </tr>    
            </table>    
           </form:form> 

 
<br/><br/><br/><br/><br/>
 
<div id="message">
<br/>
</div>
 
</div>

</body>
</html>