<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Users</title>
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
  <option value="addproduct">Add New Product</option>
</select>
</form:form>

    <table  border=1>
        <thead>
            <tr>
                <th>Item ID</th>
                <th>Price</th>
                <th>Name</th>
               
                <th>Image Path</th>
                 <th>Item Type</th>
                 <th>Image</th>
                 <th>Image 2</th>
                 <th colspan=2>Action</th>
                
        
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="item">
                <tr>
                    <td><c:out value="${item.itemid}" /></td>
                    <td><c:out value="${item.price}" /></td>
                    <td><c:out value="${item.name}" /></td>                
                    <td><c:out value="${item.imagepath}" /></td>
                    <td><c:out value="${item.type}" /></td>
                       <td><img src=<c:out value='${item.imagepath} '/> alt="Trolltunga Norway" width="300" height="200"></td>
                  <td><a href="edititem/${item.itemid}">Edit</a></td>  
   <td><a href="deleteitem/${item.itemid}">Delete</a></td>  
                
                     </tr>
            </c:forEach>
        </tbody>
    </table>
  <jsp:include page="my-footer.jsp"></jsp:include>
</body>
</html>