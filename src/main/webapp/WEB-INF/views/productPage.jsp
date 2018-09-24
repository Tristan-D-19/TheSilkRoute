<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "com.aws.codestar.silkroute.models.*"%>
	<%@page import = "java.util.*"%>
<%@ page import = "com.aws.codestar.silkroute.service.*" %> 
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>s
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="css/productDescription.css" rel="stylesheet">
<link href="/css/custom-navbar.css" rel="stylesheet">
</head>
<body>
<sec:authorize access="isAuthenticated()">
    
    <%@include file ="authenticated-nav.jsp" %>
  <sec:authentication property="principal.firstName" var="firstName" />
</sec:authorize>
<sec:authorize access="!isAuthenticated()">

	<%@include file ="custom-navbar.jsp"%>	
</sec:authorize>
<% Product p = (Product) request.getAttribute("product");
HashSet<OrderDetail> cart = (HashSet<OrderDetail>) request.getSession().getAttribute("cart");
%>
<div class="container">
        	<div class="row">
               <div class="col-xs-4 item-photo">
                    <img style="max-width:100%;" src="https://picsum.photos/420/320?image=0"  style="width:50%"/>
                </div>
                <div class="col-xs-5" style="border:0px solid gray; margin-left: 10px;">
                   
                    <h3><%=p.getProductName() %></h3>    
                    <h5 style="color:#337ab7">Provided by <a href="#">The Silk Road</a> · <small style="color:#337ab7">(5054 views)</small></h5>
        
                    
                   
                    <h3 style="margin-top:0px;">$<%=p.getPrice() %></h3>
        
                    <!-- Detalles especificos del producto -->
                  
                    <div class="section" style="padding-bottom:20px;">
                        <h6 class="title-attr"><small><%=p.getQuantity() %></small></h6>                    
                        <div>
                            <div class="btn-minus"><span class="glyphicon glyphicon-minus"></span></div>
                            <input value="1" />
                            <div class="btn-plus"><span class="glyphicon glyphicon-plus"></span></div>
                        </div>
                    </div>                
        
                    <!-- Botones de compra -->
                  
                   
                    <div class="section" style="padding-bottom:20px;">
                         <form action="/cart/add" method="POST" id="cart-form">
                         <input type="hidden" name="productId" value="<%=p.getProductId()%>"/>
                        <button id='addItem' class="btn btn-success"><span style="margin-right:20px" class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>Add To Cart</button>
                    	 </form>
                    </div>                                        
                </div>                              
        
                <div class="col-xs-9">
               
                    <h2> Product Details</h2>
                    <div style="width:100%;border-top:1px solid silver">
                        <p style="padding:15px;">
                            <small>
                          <% out.println(p.getProductDescription());%>
                            </small>
                        </p>
                        
                    </div>
                </div>		
            </div>
        </div>    
        <script src="js/productDescription.js" type="text/javascript"> </script>    
</body>
</html>