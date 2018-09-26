<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<sec:authorize access="isAuthenticated()">
   <sec:authentication var="user" property="principal" />
   <sec:authentication var="principal" property="principal" />
</sec:authorize>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>

hello ${principal.email}
</div>
</body>
</html>