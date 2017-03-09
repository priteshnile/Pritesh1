<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Add new user</title>
</head>
<body>
<jsp:include page="my-header.jsp"></jsp:include>
<form:form method="POST"  name="myitemform" >
 Select Action
 <select name="forma" onchange="location = this.value;">
 <option value="0">Select Action</option>
 <option value="viewusers">View All Users</option>
 <option value="viewitems">View All Items</option>
 <option value="addcategory">Add New Category</option>
 <option value="item">Add New Item</option>
</select>
</form:form>
    <script>
       
    </script>

   <h1>Add New Product</h1>  
           <form:form method="POST" action="${pageContext.request.contextPath}/saveproduct" name="myform" onsubmit="return validateform()">    
            <table >    
            <tr>  
            <td></td>    
             <td><form:hidden  path="productid" /></td>  
             </tr>   
             <tr>    
              <td> Product Name : </td>   
              <td><form:input path="productname"  /></td>  
             </tr>    
              <tr>
        <td>Category :</td>
        <td>
            <form:select path="category.categoryid" >
            <form:option value="0" label="Select Category" />
            
            <c:forEach items="${list}" var="c">
         <form:option value="${c.categoryid}">${c.categoryname}</form:option>
        </c:forEach>         
         </form:select>
        </td>
    </tr>
                <tr>    
              <td> </td>    
              <td><input type="submit" value="Submit" /></td>    
             </tr>  
            
             
            </table>    
           </form:form> 
            <jsp:include page="my-footer.jsp"></jsp:include>
</body>
</html>