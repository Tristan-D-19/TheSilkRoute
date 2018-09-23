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
<title>Insert title here</title>
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="/jquery/jquery-1.11.1.min.js"></script>
<link href="/css/cart.css" rel="stylesheet">
<link href="css/custom-navbar.css" rel="stylesheet">
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
 <%HashSet<OrderDetail> cart = (HashSet<OrderDetail>) request.getSession().getAttribute("cart"); %>
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
                                out.println("<h4 class='media-heading'><a href='/products/" + item.getProduct().getProductId()+ "'>Product name</a></h4>");
                                out.println("<h5 class='media-heading'> by <a href='#'>Brand name</a></h5>");
                                out.println("<span>Status: </span><span class='text-success'><strong>In Stock</strong></span>'");
                            out.println("</div>");                        
                            out.println("</div></td>");
                        out.println("<td class='col-sm-1 col-md-1' style='text-align: center'>");
                        out.println("<input type='email' class='form-control' id='exampleInputEmail1' value='"+item.getOrderQuantity()+"'>");
                        out.println("</td>");
                        out.println("<td class='col-sm-1 col-md-1 text-center'><strong>"+item.getPrice()+"</strong></td>");
                        out.println("<td class='col-sm-1 col-md-1 text-center'><strong>$14.61</strong></td>");
                        out.println("<td class='col-sm-1 col-md-1'>");
                        out.println("<button type='button' class='btn btn-danger'>");
                            out.println("<span class='glyphicon glyphicon-remove'></span> Remove</button></td>");
                    out.println("</tr>");
                    }%>
                    <tr>
                        <td class="col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/72/product-icon.png" style="width: 72px; height: 72px;"> </a>
                            <div class="media-body">
                                <h4 class="media-heading"><a href="#">Product name</a></h4>
                                <h5 class="media-heading"> by <a href="#">Brand name</a></h5>
                                <span>Status: </span><span class="text-warning"><strong>Leaves warehouse in 2 - 3 weeks</strong></span>
                            </div>
                        </div></td>
                        <td class="col-md-1" style="text-align: center">
                        <input type="email" class="form-control" id="exampleInputEmail1" value="2">
                        </td>
                        <td class="col-md-1 text-center"><strong>$4.99</strong></td>
                        <td class="col-md-1 text-center"><strong>$9.98</strong></td>
                        <td class="col-md-1">
                        <button type="button" class="btn btn-danger">
                            <span class="glyphicon glyphicon-remove"></span> Remove
                        </button></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h5>Subtotal</h5></td>
                        <td class="text-right"><h5><strong>$24.59</strong></h5></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h5>Estimated shipping</h5></td>
                        <td class="text-right"><h5><strong>$6.94</strong></h5></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td><h3>Total</h3></td>
                        <td class="text-right"><h3><strong>$31.53</strong></h3></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>
                        <button type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
                        </button></td>
                        <td>
                        <button type="button" class="btn btn-success">
                            Checkout <span class="glyphicon glyphicon-play"></span>
                        </button></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>