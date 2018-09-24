<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "com.aws.codestar.silkroute.service.*" %> 
    <%@page import = "java.util.*"%>
<%@page import = "com.aws.codestar.silkroute.models.*"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>

 <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="/jquery/jquery-1.11.1.min.js"></script>

<link href="/css/authenticated-navbar.css" rel="stylesheet">
<link href="/css/custom-navbar.css" rel="stylesheet">
<link href="/css/cart.css" rel="stylesheet">
 <%HashSet<OrderDetail> cart = (HashSet<OrderDetail>) request.getSession().getAttribute("cart"); 
 double total = 0;
 %>
</head>
<body>
<sec:authorize access="isAuthenticated()">  
    <%@include file ="authenticated-nav.jsp" %>
  <sec:authentication property="principal.firstName" var="firstName" />
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
	<%@include file ="custom-navbar.jsp"%>	
</sec:authorize>

<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th class="text-center">Price</th>
                        <th class="text-center">Total</th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    
                    for(OrderDetail item: cart){
                    out.println("<tr>");
                        out.println("<td class='col-sm-8 col-md-6'>");
                        out.println("<div class='media'>");
                            out.println("<a class='thumbnail pull-left' href='#'> <img class='media-object' src='http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/72/product-icon.png' style='width: 72px; height: 72px;'> </a>");
                            out.println("<div class='media-body'>");
                                out.println("<h4 class='media-heading'><a href='/products/" + item.getProduct().getProductId()+ "'>"+item.getProduct().getProductName()+"</a></h4>");
                                out.println("<h5 class='media-heading'> by <a href='#'>The Silk Road</a></h5>");
                                out.println("<span>Status: </span><span class='text-success'><strong>In Stock</strong></span>'");
                            out.println("</div>");                        
                            out.println("</div></td>");
                        out.println("<td class='col-sm-1 col-md-1' style='text-align: center'>");
                        out.println("<input type='text' class='form-control' id='exampleInputEmail1' value='1'>");
                        out.println("</td>");
                        out.println("<td class='col-sm-1 col-md-1 text-center'><strong>"+item.getProduct().getPrice()+"</strong></td>");
                        out.println("<td class='col-sm-1 col-md-1 text-center'><strong>$14.61</strong></td>");
                        out.println("<td class='col-sm-1 col-md-1'>");
                        out.println("<button type='button' class='btn btn-danger'>");
                            out.println("<span class='glyphicon glyphicon-remove'></span> Remove</button></td>");
                    out.println("</tr>");
                    total += item.getPrice(); }%>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h5>Subtotal</h5></td>
                        <td class="text-right"><h5><strong><%=total %></strong></h5></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h5>Estimated shipping</h5></td>
                        <td class="text-right"><h5><strong>$0</strong></h5></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h3>Total</h3></td>
                        <td class="text-right"><h3><strong><%=total %></strong></h3></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>
                        <button id="market" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
                        </button></td>
                        <td>
                        <button id="checkout" type="button" class="btn btn-success">
                            Checkout <span class="glyphicon glyphicon-play"></span>
                         
                        </button></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script type="text/javascript">
document.getElementById("checkout").onclick = function () {
    location.href = "/checkout";
};
document.getElementById("market").onclick = function () {
    location.href = "/market";
};
</script>
</body>
</html>