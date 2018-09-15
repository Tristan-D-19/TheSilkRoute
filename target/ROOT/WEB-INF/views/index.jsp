<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.aws.codestar.silkroute.service.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<link href="webjars/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="webjars/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="webjars/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="css/index.css" rel="stylesheet">
<link href="css/custom-navbar.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href=webjars/font-awesome/4.7.0/css/font-awesome.min.css" />
<title>TSR</title>
<%
%>
</head>
<body>
<%@include file ="custom-navbar.html"%>	
<div class="search-box">
    <input class="search-txt" type="text" name="" placeholder="Type to search">
    <a class="search-btn" href="#">
        <i class="fas fa-search"></i>
    </a>
</div>
</body>
</html>