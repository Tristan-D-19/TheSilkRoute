<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="/css/loginpage.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<title>Login/Register</title>
</head>


<body>	
  
         <div class="container">
      <div class="col-md-6 mx-auto text-center">
         <div class="header-title">
            <h1 class="wv-heading--title">
                  Login
            </h1>
         </div>
      </div>
      <div class="row">
         <div class="col-md-4 mx-auto">
            <div class="myform form ">
               <form:form action="/auth/login" method="POST"  modelAttribute="user">
                  <div class="form-group">
                     <form:input type="email" path="email"  class="form-control my-input" id="email" placeholder="E-mail"/>
                  </div>
                  <div class="form-group">
                     <form:input type="password" path="password"  class="form-control my-input" id="password" placeholder="Password"/>
                  </div>
               
                  <div class="text-center ">
                     <button type="submit" class=" btn btn-block send-button tx-tfm">Login</button>
                  </div>
                  <div class="col-md-12 ">
                     <div class="login-or">
                        <hr class="hr-or">
                        <span class="span-or">or</span>
                     </div>
                  </div>
                  <div class="form-group">
                     <a class="btn btn-block g-button" href="/auth/register">
                     <i class="fa fa-google"></i> Register
                     </a>
                  </div>        
               </form:form>
            </div>
         </div>
      </div>
   </div>
</body>
</html>