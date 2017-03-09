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
Add Items
    <script>
       
    </script>

    <form method="POST" action="saveitem" name="frmAddItem">
    <table>
    <tr>
       <td> Price :</td> <td><input
            type="text" name="price"
            value="<c:out value="${item.price}" />" />  </td>
           </tr>
           <tr>
      <td>  Item Name : </td><td><input
            type="text" name="name"
            value="<c:out value="${item.name}" />" />  </td>
            <tr>
      <td>   Item Image Path : </td><td><input
            type="text" name="imagepath"
            value="<c:out value="${item.imagepath}" />" />  </td>
            </tr>

            <tr>
             <td>Category: </td>
             <td>

             <select name="forma" onchange="location = this.value;">
            
             <option value="">Select Category</option>
             <option value="addcategory">Add new Category</option>
             <c:forEach items="${list}" var="c">
             <option value="${c.categoryid}">${c.categoryname}</option>
             
             </c:forEach>
  
    </select>
    </td>
    </tr>

</table>
<br/><br/> 
        
             
            <input type="submit" value="Submit" />
    </form>
    <jsp:include page="my-footer.jsp"></jsp:include>
</body>
</html>