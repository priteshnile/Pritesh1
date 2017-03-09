<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
</script>
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/order.js"></script>
<style>
	lr {
    float: right;
     display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}
	</style>
	
</head>
<body>


<jsp:include page="my-header.jsp"></jsp:include>

<div class="clearfix"></div>
<body>
<div align="right">

<a id="kart" href="${pageContext.request.contextPath}/kart" >Kart</a>
</div>

<div align="right">
<p id="msg">Successfully added into kart.</p>
</div>

<form>
    <table  border=1>
        <thead>
            <tr>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="item">
                <tr>
      <img  src="${item.imagepath}" alt="Trolltunga Norway" width="300" height="200">
      <input type="hidden" class="itemid" value="${item.itemid }"/>
      
              
            <c:out  value="${item.price}" />
                    <c:out value="${item.name}" /> 
                   <input class="AddToKart" id="${item.itemid}" type="button" value="AddToKart" />    
                  </tr>
            </c:forEach>
        </tbody>
    </table>
  </form> 
</body>

 <input type="hidden" id="pagename" value=" ${productid}"/>
<jsp:include page="my-footer.jsp"></jsp:include>

</body>
</html>