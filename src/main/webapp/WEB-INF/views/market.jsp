<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "java.util.*"%>
<%@page import = "com.aws.codestar.silkroute.models.*"%>
<%@ page import = "com.aws.codestar.silkroute.service.*" %> 
<!DOCTYPE html>
<html>
<head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

 <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<script src="/jquery/jquery.min.js"></script>
<link href="/css/market.css" rel="stylesheet">
<link href="css/custom-navbar.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Market</title>
</head>
<body>
<%@include file ="custom-navbar.html" %>
 
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
        </div>	
    	<!-- BEGIN PRODUCTS -->
    	 <div class="col">
            <div class="row">
  		<%
  		if(request.getAttribute("products") != null) {

  			List<Product> products = (List<Product>) request.getAttribute("products");
  			  
  				for(Product  p: products) {	
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
      			out.println("<div class='col'>");
      				out.println("<button class='btn btn-success right'  >Add to Cart</button>");
      			out.println("</div>");
      			
      				 out.println("</div>");
      				 out.println("</div>");
      				 out.println("</div>");
    		 out.println("</div>");
    		
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
</body>
</html>