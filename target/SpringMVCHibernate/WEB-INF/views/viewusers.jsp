<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
  
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
  
<h1>Users List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>UserId</th><th>First Name</th><th>Last Name</th><th>Email</th>
<th>User Type</th><th>Phone Number</th>
<th>Gender</th><th>City</th>

<th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="user" items="${list}">   
   <tr>  
   <td>${user.userid}</td>  
   <td>${user.firstName}</td>  
   <td>${user.lastName}</td>  
   <td>${user.email}</td> 
   <td>${user.usertype}</td>  
   <td>${user.phone_no}</td>  
   <td>${user.gender}</td>  
   <td>${user.city}</td>  
   <td><a href="edituser/${user.userid}">Edit</a></td>  
   <td><a href="deleteuser/${user.userid}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
  <jsp:include page="my-footer.jsp"></jsp:include>
   </body>