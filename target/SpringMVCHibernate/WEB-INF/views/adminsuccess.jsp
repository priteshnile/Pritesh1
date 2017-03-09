<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

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
 <script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/main.js"></script>
<script type="text/javascript">

</script>


<jsp:include page="my-header.jsp"></jsp:include>
 
  
 <form:form method="POST"  name="myitemform" >


 Select Action
 <select id="select" name="forma" onchange="location = this.value;">
 <option value="0">Select Action</option>
 <option value="viewusers">View All Users</option>
 <option value="viewitems">View All Items</option>
 <option value="addcategory">Add New Category</option>
 <option value="item">Add New Item</option>
 <option value="addproduct">Add New Product</option>
</select>
<br/>
</form:form>
<div class="clearfix"></div>
<jsp:include page="my-footer.jsp"></jsp:include>


</body>
</html>