<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.aws.codestar.silkroute.service.*" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
   
   <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open Sans">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script> 
<script src="jquery.min.js"></script>
<link href="css/reg.css" rel="stylesheet">
 <title>TSR</title>
</head>
<body>
<!-- multistep form -->
<!-- Grid row -->
<!-- MultiStep Form -->
  <!-- Bootstrap tooltips -->
<script
  src="https://code.jquery.com/jquery-2.1.3.js"
  integrity="sha256-goy7ystDD5xbXSf+kwL4eV6zOPJCEBD1FBiCElIm+U8="
  crossorigin="anonymous"></script>
    <script  src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script  src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
        <script type="text/javascript" src="js/reg.js"></script>
    
<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <form:form  class="needs-validation" novalidate="" action="/register" id="msform" name="register" method="post" modelAttribute="user">
            <!-- progressbar -->
          
            <!-- fieldsets -->
            <fieldset>
                <h2 class="fs-title">Personal Details</h2>
                <h3 class="fs-subtitle">Tell us something more about you</h3>
                <div class="form-group"> 
	                <div class="inputGroupContainer">
		               <div class="input-group">
		                  <form:input class="form-control" type="text" path="firstName" required="" placeholder="First Name"/>			 
					   </div> 
	                </div>
                </div>
               
               <div class="form-group"> 
	                <div class="inputGroupContainer">
		               <div class="input-group">
                <form:input class="form-control" type="text" path="lastName" required="" placeholder="Last Name"/>
                   </div> 
	                </div>
                </div>
                
                 <div class="form-group"> 
	                <div class="inputGroupContainer">
		               <div class="input-group">
                <form:input class="form-control" type="email" path="email" required="" placeholder="email"/>
               	   </div> 
	                </div>
                </div>
               
                 <div class="form-group"> 
	                <div class="inputGroupContainer">
		               <div class="input-group">
                <form:input class="form-control" type="password" path="password" required="" placeholder="Password"/>
                    </div> 
	                </div>
                </div>
               
                  <div class="form-group"> 
	                <div class="inputGroupContainer">
		               <div class="input-group">
                <form:input class="form-control" type="password" path="passwordConfirm"  required="" placeholder="Confirm Password"/>
                   </div> 
	                </div>
                </div>
               
                 <div class="form-group"> 
	                <div class="inputGroupContainer">
		               <div class="input-group">
                <form:input class="form-control" type="text" path="phone" placeholder="phone"/>
                    </div> 
	                </div>
                </div>                            
               
                
               
                  <div class="form-group"> 
	                <div class="inputGroupContainer">
		               <div class="input-group">
                <form:input class="form-control" type="text" path="address" placeholder="Address"/>
               	   </div> 
	                </div>
                </div>     
               
               
                  <div class="form-group"> 
	                <div class="inputGroupContainer">
		               <div class="input-group">
                <form:input class="form-control" type="text" path="city" placeholder="City"/>
              	   </div> 
	                </div>
                </div>
              
               <div class="form-group"> 
	                <div class="inputGroupContainer">
		               <div class="input-group">
                <form:input class="form-control" type="text" path="state" placeholder="State"/>
                  </div> 
	                </div>
                </div>
                
                  <div class="form-group"> 
	                <div class="inputGroupContainer">
		               <div class="input-group">
                 <form:input class="form-control" type="text" path="zipcode" placeholder="Zipcode"/>
                   </div> 
	                </div>
                </div>
                
                <input type="submit" name="submit" class="submit action-button" value="Submit"/>
            
        </form:form>
        <!-- link to designify.me code snippets -->
        <div class="dme_link">
            <p><a href="/login" target="_blank">Login</a></p>
        </div>
    </div>
</div>
<!-- /.MultiStep Form -->
    <!-- Grid column -->

</div>
<!-- Grid row -->


<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>

<script type="text/javascript">
 
   $(document).ready(function() {
    $('#msform').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            firstName: {
                validators: {
                        stringLength: {
                        min: 2,
                    },
                        notEmpty: {
                        message: 'Please supply your first name'
                    }
                }
            },
             lastName: {
                validators: {
                     stringLength: {
                        min: 2,
                    },
                    notEmpty: {
                        message: 'Please supply your last name'
                    }
                }
            },
           
            phone: {
                validators: {
                    notEmpty: {
                        message: 'Please supply your phone number'
                    },
                    phone: {
                        country: 'US',
                        message: 'Please supply a vaild phone number with area code'
                    }
                }
            },
            address: {
                validators: {
                     stringLength: {
                        min: 8,
                    },
                    notEmpty: {
                        message: 'Please supply your street address'
                    }
                }
            },
            city: {
                validators: {
                     stringLength: {
                        min: 4,
                    },
                    notEmpty: {
                        message: 'Please supply your city'
                    }
                }
            },
            state: {
                validators: {
                    notEmpty: {
                        message: 'Please select your state'
                    }
                }
            },
            zipcode: {
                validators: {
                    notEmpty: {
                        message: 'Please supply your zip code'
                    },
                    zipCode: {
                        country: 'US',
                        message: 'Please supply a vaild zip code'
                    }
                }
            },
		
	 email: {
                validators: {
                    notEmpty: {
                        message: 'Please supply your email address'
                    },
                    emailAddress: {
                        message: 'Please supply a valid email address'
                    }
                }
            },
					
	password: {
            validators: {
                identical: {
                    field: 'confirmPassword',
                    message: 'Confirm your password below - type same password please'
                }
            }
        },
        passwordConfirm: {
            validators: {
                identical: {
                    field: 'password',
                    message: 'The password and its confirm are not the same'
                }
            }
         },
			
            
            }
        })
		
 	
        .on('success.form.bv', function(e) {
            $('#success_message').slideDown({ opacity: "show" }, "slow") // Do something ...
                $('#msform').data('bootstrapValidator').resetForm();

            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');

            // Use Ajax to submit form data
            
            $.post($form.attr('action'), $form.serialize(), function(result) {
                console.log(result);
            }, 'json');
        });
});


 
 </script>
    
</body>
</html>