<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>


<body>	
<div id="header" style="background-color:black;height:15%;width:100%">
<%@include file ="Header.html"%>
</div>
	
		
<div id="page-content" style="background-color:grey;height:70%;text-align:center;">
<form action="Login" method="POST">
			<input name="user" type="text" placeholder="Username"/>
			<input name="pass" type="password" placeholder="Password"/>
			<input id="login" type="submit" value="Login"/>
		</form>
</div>
<div id="footer" style="background-color:black;height:10%;width:100%; bottom:0; position:relative;">
<%@include file ="Footer.html"%>	
</div>	
</body>
</html>