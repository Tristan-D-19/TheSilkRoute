<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import = "com.aws.codestar.silkroute.service.*" %> 
<%@page import = "java.util.*"%>
<%@page import = "com.aws.codestar.silkroute.models.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
 <% User user = (User) session.getAttribute("user"); %>
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="/jquery/jquery-1.11.1.min.js"></script>

<link href="/css/authenticated-navbar.css" rel="stylesheet">
<link href="/css/custom-navbar.css" rel="stylesheet">
<link href="/css/profile.css" rel="stylesheet">
</head>
<body>
<sec:authorize access="isAuthenticated()">
   
    <%@include file ="authenticated-nav.jsp" %>
  <sec:authentication property="principal.firstName" var="firstName" />
</sec:authorize>
<sec:authorize access="!isAuthenticated()">

	<%@include file ="custom-navbar.jsp"%>	
</sec:authorize>

hello ${firstName}

<form:form class="form-horizontal" action="/users/profile/update" method="POST" modelAttribute="user" id="update_user_form">
    <fieldset>
      
      <!-- Form Name -->
      <legend> Personal Information </legend>
    
      <!-- Text input-->
      
      <div class="form-group">
        <label class="col-md-4 control-label">First Name</label>
        <div class="col-md-6  inputGroupContainer">
          <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <form:input  path="firstName" placeholder="First Name" class="form-control"  type="text"/>
          </div>
        </div>
      </div>
      
      <!-- Text input-->
      
      <div class="form-group">
        <label class="col-md-4 control-label" >Last Name</label>
        <div class="col-md-6  inputGroupContainer">
          <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <form:input path="lastName" placeholder="Last Name" class="form-control"  type="text"/>
          </div>
        </div>
      </div>
      
    
      <!-- Text input-->
      
      <div class="form-group">
        <label class="col-md-4 control-label">Phone</label>
        <div class="col-md-6  inputGroupContainer">
          <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
            <form:input path="phone" placeholder="(000)000-0000" class="form-control" type="text"/>
          </div>
        </div>
      </div>
      
      <!-- Text input-->
      
      <div class="form-group">
        <label class="col-md-4 control-label">Address</label>
        <div class="col-md-6  inputGroupContainer">
          <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
            <form:input path="address" placeholder="Address" class="form-control" type="text"/>
          </div>
        </div>
      </div>
      
      <!-- Text input-->
      
      <div class="form-group">
        <label class="col-md-4 control-label">City</label>
        <div class="col-md-6  inputGroupContainer">
          <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
            <form:input path="city" placeholder="city" class="form-control"  type="text"/>
          </div>
        </div>
      </div>
      
      <!-- Select Basic -->
      
      <div class="form-group">
        <label class="col-md-4 control-label">State</label>
        <div class="col-md-6 selectContainer">
          <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
            <form:select path="state" class="form-control selectpicker" >
              <option value=" " >Please select your state</option>
              <option>Alabama</option>
              <option>Alaska</option>
              <option >Arizona</option>
              <option >Arkansas</option>
              <option >California</option>
              <option >Colorado</option>
              <option >Connecticut</option>
              <option >Delaware</option>
              <option >District of Columbia</option>
              <option> Florida</option>
              <option >Georgia</option>
              <option >Hawaii</option>
              <option >daho</option>
              <option >Illinois</option>
              <option >Indiana</option>
              <option >Iowa</option>
              <option> Kansas</option>
              <option >Kentucky</option>
              <option >Louisiana</option>
              <option>Maine</option>
              <option >Maryland</option>
              <option> Mass</option>
              <option >Michigan</option>
              <option >Minnesota</option>
              <option>Mississippi</option>
              <option>Missouri</option>
              <option>Montana</option>
              <option>Nebraska</option>
              <option>Nevada</option>
              <option>New Hampshire</option>
              <option>New Jersey</option>
              <option>New Mexico</option>
              <option>New York</option>
              <option>North Carolina</option>
              <option>North Dakota</option>
              <option>Ohio</option>
              <option>Oklahoma</option>
              <option>Oregon</option>
              <option>Pennsylvania</option>
              <option>Rhode Island</option>
              <option>South Carolina</option>
              <option>South Dakota</option>
              <option>Tennessee</option>
              <option>Texas</option>
              <option> Uttah</option>
              <option>Vermont</option>
              <option>Virginia</option>
              <option >Washington</option>
              <option >West Virginia</option>
              <option>Wisconsin</option>
              <option >Wyoming</option>
            </form:select>
          </div>
        </div>
      </div>
      
      <!-- Text input-->
      
      <div class="form-group">
        <label class="col-md-4 control-label">Zip Code</label>
        <div class="col-md-6  inputGroupContainer">
          <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
            <form:input path="zipcode" placeholder="Zip Code" class="form-control"  type="text"/>
          </div>
        </div>
      </div>
      
        <!-- Text area -->
      
     
       </fieldset>
       	<legend> Account information </legend>
        <fieldset>
        <!-- Text input-->
      <div class="form-group">
        <label class="col-md-4 control-label">E-Mail</label>
        <div class="col-md-6  inputGroupContainer">
          <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
            <form:input path="email" placeholder="E-Mail Address" class="form-control"  type="text"/>
          </div>
        </div>
      </div>
      
    
        <div class="form-group has-feedback">
            <label for="password"  class="col-md-4 control-label">
                    Password
                </label>
                <div class="col-md-6  inputGroupContainer">
                <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
            <form:input class="form-control" id="userPw" type="password" placeholder="password" 
                       path="password" data-minLength="5"
                       data-error="some error"
                       required=""/>
                <span class="glyphicon form-control-feedback"></span>
                <span class="help-block with-errors"></span>
                </div>
             </div>
        </div>
     
        <div class="form-group has-feedback">
            <label for="confirmPassword"  class="col-md-4 control-label">
                   Confirm Password
                </label>
                 <div class="col-md-6  inputGroupContainer">
                <div class="input-group"> <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
            <form:input class="form-control {$borderColor}" id="userPw2" type="password" placeholder="Confirm password" 
                       path="passwordConfirm" data-match="#confirmPassword" data-minLength="5"
                       data-match-error="some error 2"
                       required=""/>
                <span class="glyphicon form-control-feedback"></span>
                <span class="help-block with-errors"></span>
      			 </div>
             </div>
        </div>
     
  
      <!-- Button -->
      <div class="form-group">
        <label class="col-md-4 control-label"></label>
        <div class="col-md-4">
          <button type="submit" class="btn btn-warning" >Send <span class="glyphicon glyphicon-send"></span></button>
        
        
        </div>
        
        <a href="/auth/login" class="btn btn-success">Log in</a>
       
         </div>
      </div>
      
    </fieldset>
   
  </form:form>

	

<!-- PrefixFree -->
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>

        <script src="js/index.js"></script>
</body>
</html>