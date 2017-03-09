<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">  
<head></head>
<body>
<script>  

</script>
      <jsp:include page="my-header.jsp"></jsp:include>
            <h1>Edit Item</h1>  
           <form:form method="POST" action="${pageContext.request.contextPath}/edititemsave" name="frm" onsubmit="return validateform()">    
            <table >    
            <tr>  
            <td></td>    
             <td><form:hidden  path="itemid" /></td>  
             </tr>   
             <tr>    
              <td> Item Name : </td>   
              <td><form:input path="name"  /></td>  
             </tr>    
             <tr>    
              <td>Item Price :</td>    
              <td><form:input path="price" /></td>  
             </tr>   
             <tr>    
              <td>Item Type :</td>    
              <td><form:input path="type" /></td>  
             </tr>   
              <tr>    
              <td>Item Image Path :</td>    
              <td><form:input path="imagepath" /></td>  
             </tr>  
              <tr>
        <td>Product :</td>
        <td>
            <form:select path="product.productid" >
            <form:option value="0" label="Select Product" />
            
            <c:forEach items="${plist}" var="p">
         <form:option value="${p.productid}">${p.productname}</form:option>
        </c:forEach>
           <%-- <form:options items="${list}" itemValue="category" itemLabel="Category Name" /> --%>
           
            </form:select>
        </td>
    </tr>
    <tr>
        <td>Category :</td>
        <td>
            <form:select path="category.categoryid" >
            <form:option value="0" label="Select Category" />
            
            <c:forEach items="${list}" var="c">
         <form:option value="${c.categoryid}">${c.categoryname}</form:option>
        </c:forEach>
           <%-- <form:options items="${list}" itemValue="category" itemLabel="Category Name" /> --%>
           
            </form:select>
        </td>
    </tr>
          
             <tr>    
              <td> </td>    
              <td><input type="submit" value="Edit Save" /></td>    
             </tr>    
            </table>    
           </form:form> 
           ${pageContext.request.contextPath}   
           </body>
           </html>
           