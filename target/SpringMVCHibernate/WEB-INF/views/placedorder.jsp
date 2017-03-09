<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	</script>
	<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/order.js"></script>

	
</head>
<body>


<jsp:include page="my-header.jsp"></jsp:include>

<div class="clearfix"></div>
<body>
 <table id="ordertable" border=1>
        <thead>
            <tr>
                <th>Sr. No.</th>
                <th>Item Id</th>
                <th>Item Name</th>
               
                <th>Image </th>
              
                 <th>Quantity</th>
                 <th>Price</th>
                   <th>Total</th>
          
            </tr>
        </thead>
        <tbody>
       
            <c:forEach items="${list}" var="item">
              <tr>
                <td></td>
                    <td><c:out value="${item.itemid}" /></td>
                    <td><c:out value="${item.name}" /></td>
                    <td><img src=<c:out value='${item.imagepath} '/> alt="Trolltunga Norway" width="300" height="200"></td>               
                    <td><c:out value="${item.quantity}"  />
                    <input type="hidden" class="q" value="${item.quantity}"> 
                    </td>
                    <td><c:out value="${item.price}" /></td>
         <td></td> 
                
                   </tr>
            </c:forEach>
        </tbody>
    </table>
<form method="POST" action="${pageContext.request.contextPath}/placeorder">
 
    <br>
     Grand Total: <input type="text" id="grandtotal" value="" />
    <br>
    <br>
       <input class="placeorder" type="submit" value="Place Order" />
    </form>
</body>
<jsp:include page="my-footer.jsp"></jsp:include>


</body>
</html>