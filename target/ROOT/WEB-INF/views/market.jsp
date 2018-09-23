<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "java.util.*"%>
<%@page import = "com.aws.codestar.silkroute.models.*"%>
<%@ page import = "com.aws.codestar.silkroute.service.*" %> 
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
 <%HashSet<OrderDetail> cart = (HashSet<OrderDetail>) request.getSession().getAttribute("cart"); %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<%
	if(request.getParameter("productId") != null){
		
		
	}



%>
<!------ Include the above in your HEAD tag ---------->

<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<link href="/css/custom-navbar.css" rel="stylesheet">
<link href="/css/market.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Market</title>
</head>
<body>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<sec:authorize access="isAuthenticated()">
    <%@include file ="authenticated-nav.jsp" %>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
	<%@include file ="custom-navbar.jsp"%>	
</sec:authorize>

 <!--  -->
<div class="container">
    <div class="row">     
        <div class="col-12 col-md-3">
            <div class="card bg-light mb-3">
                <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
                <ul class="list-group category_block">
                    <li class="list-group-item"><a href="/market#engineering">Engineering</a></li>
                    <li class="list-group-item"><a href="/market#webdevelopment">Web Development</a></li>
                    <li class="list-group-item"><a href="/market#photography">Photography</a></li>
                    <li class="list-group-item"><a href="/market#music">Music</a></li>
                    <li class="list-group-item"><a href="/market#writing">Writing</a></li>
                    <li class="list-group-item"><a href="/market#marketing">Marketing</a></li>
                    <li class="list-group-item"><a href="/market#videography">Videography</a></li>
               		<li class="list-group-item"><a href="/market#graphicdesign">Graphic Design</a></li>
                </ul>         
             </div>
               <div class="card bg-light mb-3">
                <div class="card-header bg-success text-white text-uppercase">Last product</div>
                <div class="card-body">
                    <img class="img-fluid" src="https://dummyimage.com/600x400/55595c/fff" />
                    <h5 class="card-title">Product title</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    <p class="bloc_left_price">99.00 $</p>
                </div>
            </div>     
        </div>	
    	<!-- BEGIN PRODUCTS -->
    	 <div class="col">
            <div class="row">
            
  		<%
  		if(request.getAttribute("products") != null) {

  			List<Product> products = (List<Product>) request.getAttribute("products");
  			  
  				for(Product  p: products) {	
  	      			out.println("<form action='/cart/add' id='cart-form' style='display:contents;'>");
  		out.println("<div class='col-12 col-md-6 col-lg-4'>");
    		out.println(" <div class='card mt-4'>");
      			out.println("<img class='card-img-top' src='https://dummyimage.com/600x400/55595c/fff' alt='Card image cap'>");
      			out.println(" <div class='card-body'>");
      			out.println("<h4 class='card-title'><a href='/products{"+p.getProductId() +"}' title='View Product'" + p.getProductName()+ "</a></h4>");
      			out.println("<div class='ratings'>");
                    out.println("<span class='glyphicon glyphicon-star'></span>");
                    out.println("<span class='glyphicon glyphicon-star'></span>");
                    out.println("<span class='glyphicon glyphicon-star'></span>");
                    out.println("<span class='glyphicon glyphicon-star'></span>");
                    out.println("<span class='glyphicon glyphicon-star-empty'></span>");
                out.println("</div>");
      			 out.println("<p class='card-text'>" + p.getProductDescription()+"</p>");
      		out.println(" <div class='row'>");
      			out.println("<div class='col'>");
      			out.println("<p class='btn btn-danger btn-block'>$"+p.getPrice()+"</p>");
      				out.println("</div>");
      			out.println("<div id='cart' class='col'>");

      				out.println("<button class='btn btn-success right' type='submit' id='addItem' name='productId' value='"+p.getProductId() +"' >Add to Cart</button>");
      				
      				out.println("</div>");
      			
      				 out.println("</div>");
      				 out.println("</div>");
      				 out.println("</div>");
    		 out.println("</div>");
    		 out.println("</form>");
  			}
  		}		
  		 %>
  		 
  		<!-- END PRODUCTS -->
  		 
	 <div class="col-12">
                    <nav aria-label="...">
                        <ul class="pagination">
                            <li class="page-item disabled">
                                <a class="page-link" href="#" tabindex="-1">Previous</a>
                            </li>
                            <li class="page-item active"><a class="page-link" href="#">1 <span class="sr-only">(current)</span></a></li>
                            <li class="page-item ">
                                <a class="page-link" href="#">2 </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#">Next</a>
                            </li>
                        </ul>
                    </nav>
                </div>
         </div>           
	</div>
</div>
</div>
<script type="text/javascript" src='/js/market.js'></script>
</body>
</html>