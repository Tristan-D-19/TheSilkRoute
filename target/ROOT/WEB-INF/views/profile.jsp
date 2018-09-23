<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>s
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
    
    <%@include file ="authenticated-nav.jsp" %>
  <sec:authentication property="principal.firstName" var="firstName" />
</sec:authorize>
<sec:authorize access="!isAuthenticated()">

	<%@include file ="custom-navbar.jsp"%>	
</sec:authorize>
</body>
</html>