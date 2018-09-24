<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
   
   <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open Sans">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script> 
<link href="/css/reg.css" rel="stylesheet">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="/css/register.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

     <form:form class="form-horizontal" action="/auth/register" method="post"  id="reg_form" modelAttribute="newUser">
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
<script type="text/javascript">
 
   $(document).ready(function() {
    $('#reg_form').bootstrapValidator({
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
                $('#reg_form').data('bootstrapValidator').resetForm();

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