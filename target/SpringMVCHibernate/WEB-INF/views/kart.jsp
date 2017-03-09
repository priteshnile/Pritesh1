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
<form method="POST" action="${pageContext.request.contextPath}/placeorder">
 <table id="myTable"  border=1>
        <thead>
            <tr>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${kart2}" var="item">
                <tr>
                <td>
      <img src="${item.imagepath}" alt="Trolltunga Norway" width="300" height="200">
      <input type="hidden" class="itemid" id="itemid" value="${item.itemid }"/>
              
            <c:out value="${item.price}" /> 
             <input type="hidden" class="price" value="${item.price}"> 
                    <c:out value="${item.name}" /> 
                   &nbsp;&nbsp; Quantity:
                    <%-- <input type="number"  min="1" max="5" value="${item.quantity}"> --%>
                    <select id="${item.itemid}" class="quantity" name="quantity" >
                    <option  value="${item.quantity}"  >${item.quantity}</option>
                    <option  value="1"  >1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
  <option value="5">5</option>
</select> 

&nbsp;&nbsp;Total: <input type="text" class="total"  value="${item.price}" />
             &nbsp;&nbsp;   <input class="removefromkart" type="button" value="Remove" />
                    </td>
                  </tr>
                
            </c:forEach>
            
        </tbody>
    </table>
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