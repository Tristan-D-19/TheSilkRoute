<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.aws.codestar.silkroute.service.*" %> 
<%@page import = "java.util.List"%>
<%@page import = "com.aws.codestar.silkroute.models.*"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>s
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

 <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<link href="/webjars/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" type="text/css" href="webjars/font-awesome/4.7.0/css/font-awesome.min.css" />
<script type="text/javascript" src="webjars/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/jquery/3.2.1/jquery.min.js"></script>
<link href="css/index.css" rel="stylesheet">
<link href="css/custom-navbar.css" rel="stylesheet">
<link href="css/home-searchbar.css" rel="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
<title>TSR</title>
<%

String keyword = "";
request.setAttribute("txtKeyword", keyword);
session = request.getSession(); 
User user = (User)session.getAttribute("user");
%>

</head>
<body>
<div>
<sec:authorize access="isAuthenticated()">
    
    <%@include file ="authenticated-nav.jsp" %>
  <sec:authentication property="principal.firstName" var="firstName" />
   hello <span><%=user.getFirstName()%> </span>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">

	<%@include file ="custom-navbar.html" %>	
</sec:authorize>
</div>
<form name="frmSearch" method="post" action="/search">
<div class="search-box">
    <input class="search-txt" type="text" name="txtKeyword" placeholder="Products, Service, Designs, etc..">
    <a class="search-btn" href="/search">
    
        <i class="fas fa-search"></i> 
    </a>   
</div>
</form>
</body>
</html>