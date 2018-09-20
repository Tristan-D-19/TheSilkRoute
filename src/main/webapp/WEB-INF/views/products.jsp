<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "java.util.*"%>
<%@page import = "com.aws.codestar.silkroute.models.*"%>
<%@ page import = "com.aws.codestar.silkroute.service.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="row">
    	<!-- BEGIN PRODUCTS -->
  		<%
  		if(request.getAttribute("products") != null) {

  			List<Product> products = (List<Product>) request.getAttribute("products");
  			  
  				for(Product  p: products) {	
  		out.println("<div class='col-md-3 col-sm-6'>");
    		out.println("<span class='thumbnail'>");
      			out.println("<img src='http://placehold.it/500x400' alt='...'>");
      			out.println("<h4>" + p.getProductName()+ "</h4>");
      			out.println("<div class='ratings'>");
                    out.println("<span class='glyphicon glyphicon-star'></span>");
                    out.println("<span class='glyphicon glyphicon-star'></span>");
                    out.println("<span class='glyphicon glyphicon-star'></span>");
                    out.println("<span class='glyphicon glyphicon-star'></span>");
                    out.println("<span class='glyphicon glyphicon-star-empty'></span>");
                out.println("</div>");
      			out.println("<p>" + p.getProductDescription()+"</p>");
      			out.println("<hr class='line'>");
      			out.println("<div class='row'>");
      				out.println("<div class='col-md-6 col-sm-6'>");
      					out.println("<p class='price'>$" + p.getPrice()+"</p>");
      				out.println("</div>");
      				out.println("<div class='col-md-6 col-sm-6'>");
      				out.println("<button class='btn btn-success right' >Add to Cart</button>");
      				 out.println("</div>");
      				
      				 out.println("</div>");
      				 out.println("</span>");
    		 out.println("</div>");
  			}
  		}		
  		 %>
  		<!-- END PRODUCTS -->
	</div>
</div>
</body>
</html>