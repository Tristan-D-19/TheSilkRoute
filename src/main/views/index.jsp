<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.aws.codestar.silkroute.models.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TSR</title>
</head>
<body>
Hello 
<%
	User user =  (User) session.getAttribute("User");
	Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
	if(user == null || loggedIn == null || loggedIn.equals(false) ){
		response.sendRedirect("Login.jsp");
	}
	else{
		response.sendRedirect("Market.jsp");
	}
%>
</body>
</html>