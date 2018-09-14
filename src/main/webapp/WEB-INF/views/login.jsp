<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<link href="webjars/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="webjars/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="webjars/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="css/auth.css" rel="stylesheet">
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href=webjars/font-awesome/4.7.0/css/font-awesome.min.css" />
		<link href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
<title>Login/Register</title>
</head>


<body>	
        <div class="container">
           
            <header>
                <h1>Login and Registration Form</h1>
				
            </header>
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister1"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <a class="hiddenanchor" id="toregister2"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form  action="/login" autocomplete="on" method="post" modelAttribute="user"> 
                                <h1>Log in</h1> 
                                <p> 
                                    <label for="email" class="email" > Your First Name </label>
                                    <input id="email" path="email" required="required" type="text" placeholder="mymail@mail.com"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd"> Your password </label>
                                    <input id="password" path="password" required="required" type="password" placeholder="eg. X8df!90EO" /> 
                                </p>
                                <p class="keeplogin"> 
									<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
									<label for="loginkeeping">Keep me logged in</label>
								</p>
                                <p class="login button"> 
									<input id=login-submit type="submit" value="Login"/> 
								</p>
                                <p class="change_link">
									Not a member yet ?
									<a href="#toregister1" class="to_register1">Join us</a>
								</p>
                            </form>
                        </div>
<!-- ---------------------------------------------------------------------------------------------->                      
                        <div id="register-forms" class="animate form">
                		 <form:form  action="/register" autocomplete="on" modelAttribute="user" > 
                        <div id="register1" class="animate form">
                           
                                <h1> Sign up </h1> 
                                <p> 
                                    <label for="firstName" class="uname" >Your First Name</label>
                                    <input id="usernamesignup" path="firstName" required="required" type="text" placeholder="mysuperusername690" />
                                </p>
                                <p> 
                                    <label for="emailsignup" class="youmail"  > Your email</label>
                                    <input id="emailsignup" name="emailsignup" required="required" type="email" placeholder="mysupermail@mail.com"/> 
                                </p>
                                <p> 
                                    <label for="passwordsignup" class="youpasswd" >Your password </label>
                                    <input id="passwordsignup" name="passwordsignup" required="required" type="password" placeholder="eg. X8df!90EO"/>
                                </p>
                                <p> 
                                    <label for="passwordsignup_confirm" class="youpasswd" >Please confirm your password </label>
                                    <input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password" placeholder="eg. X8df!90EO"/>
                                </p>
                                <p class="signin button"> 
									
									<a href="#toregister2" class="to_register2"> Go and log in </a>
								</p>
                                <p class="change_link">  
									Already a member ?
									<a href="#tologin" class="to_register1"> Go and log in </a>
								</p>
                           
                        </div>
<!-- ---------------------------------------------------------------------------------------------->                      						
						<div id="register2" class="animate form">
                           
                                <h1> Sign up </h1> 
                                <p> 
                                    <label for="usernamesignup" class="uname" >Your First Name</label>
                                    <input id="usernamesignup" name="usernamesignup" required="required" type="text" placeholder="mysuperusername690" />
                                </p>
                                <p> 
                                    <label for="emailsignup" class="youmail"  > Your Last Name</label>
                                    <input id="emailsignup" name="emailsignup" required="required" type="email" placeholder="mysupermail@mail.com"/> 
                                </p>
                                <p> 
                                    <label for="passwordsignup" class="youpasswd" >Your password </label>
                                    <input id="passwordsignup" name="passwordsignup" required="required" type="password" placeholder="eg. X8df!90EO"/>
                                </p>
                                <p> 
                                    <label for="passwordsignup_confirm" class="youpasswd" >Please confirm your password </label>
                                    <input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password" placeholder="eg. X8df!90EO"/>
                                </p>
                                <p class="signin button"> 
									<input type="submit" value="Sign up"/> 
								</p>
                                <p class="change_link">  
									Already a member ?
									<a href="#tologin" class="to_register1"> Go and log in </a>
								</p>
								</div>
                            </form:form>
                        </div>
<!-- ---------------------------------------------------------------------------------------------->                      
                       
                    </div>
                </div>  
            </section>
        </div>
</body>
</html>