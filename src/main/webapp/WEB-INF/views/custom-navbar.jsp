<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "java.util.*"%>
<%@page import = "com.aws.codestar.silkroute.models.*"%>
<%@ page import = "com.aws.codestar.silkroute.service.*" %> 
<% HashSet<OrderDetail> navcart = (HashSet<OrderDetail>) request.getSession().getAttribute("cart"); %>
<nav class="navbar navbar-expand-md navbar-light sticky-top bg-light">
    <div class="navbar-header">
	      <button type="button" class="navbar-toggler " data-toggle="collapse" data-target="#myNavbar">
	        <span class="navbar-toggler-icon"></span>
	      </button>
	      <a class="navbar-brand" href="/">Silk</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
	      <ul class="navbar-nav">
	        <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
	       	<li class="nav-item"><a class="nav-link" href="/market">Market</a></li>

	      
	      </ul>
      
	      <ul class="nav navbar-nav ml-auto">
	      
	       <li class="nav-item"><a class=" nav-link  btn btn-success btn-sm ml-3" href="/cart">
	                    <i class="fa fa-shopping-cart"></i> Cart
	                    <span class="badge badge-light"><%=navcart.size()%></span>
	                </a></li>
	        <li class="nav-item"><a class="nav-link" href="/auth/register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
	        <li class="nav-item"><a class="nav-link" href="/auth/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	      </ul>
    </div>

</nav>
