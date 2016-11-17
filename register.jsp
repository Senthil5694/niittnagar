<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>register
</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
.colorgraph {
  height: 5px;
  border-top: 0;
 background: #c4e17f;
  border-radius: 5px;
  
background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);

background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);

background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);

background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
}
</style>
</head>
<%@include file="header.jsp" %>
<body>
<h1>${msg}</h1>
<div class="container">

<div class="row">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		
<form:form action="registersuccess" commandName="registerModel" role="form">
			<h2>Please Sign Up <small>It's free and always will be.</small></h2>
			
<hr class="colorgraph">
			<div class="row">
				
<div class="col-xs-12 col-sm-6 col-md-6">
					
<div class="form-group">
                      
  <input type="text" name="firstname" class="form-control input-lg"  required="true" placeholder="First Name" tabindex="1">

					</div>
				
</div>
				
<div class="col-xs-12 col-sm-6 col-md-6">
					
<div class="form-group">
						
<input type="text" name="lastname"  class="form-control input-lg" required="true" placeholder="Last Name" tabindex="2">
	
</div>
	
</div>
	
</div>
	
<div class="form-group">

<input type="text" name="username"  class="form-control input-lg" required="true" placeholder="User name" tabindex="3">
			
</div>

<div class="form-group">
<input type="email" name="emailid" class="form-control input-lg" required="true" placeholder="Email" tabindex="4">

</div>

<div class="form-group">

<input type="text" name="address"  class="form-control input-lg"  required="true" placeholder="Address" tabindex="4">

</div>

<div class="row">

<div class="col-xs-12 col-sm-6 col-md-6">

<div class="form-group">

<input type="password" name="password"  class="form-control input-lg" required=""true" pattern=".{5,20}" title="Password should contain minimum 5 letters" placeholder="Password" tabindex="5">
	
</div>

</div>

<div class="col-xs-12 col-sm-6 col-md-6">
					
<div class="form-group">

<input type="text" name="mobilenumber"  class="form-control input-lg"  required="true" pattern="[789][0-9]{9}" title="Enter a valid mobile number" placeholder="Mobile Number" tabindex="6">

</div>

</div>

</div>

<div class="row">

<div class="col-xs-4 col-sm-3 col-md-3">

<span class="button-checkbox">

<button type="button" class="btn" data-color="info" tabindex="7">I Agree</button>
 
<input type="checkbox" name="t_and_c" id="t_and_c" class="hidden" value="1">

</span>
				</div>
				
<div class="col-xs-8 col-sm-9 col-md-9">
 By clicking <strong class="label label-primary">Register</strong>, you agree to the <a href="login" data-toggle="modal" data-target="#t_and_c_m">Terms and Conditions</a> set out by this site, including our Cookie Use.
				
</div>

</div>
	
<hr class="colorgraph">
	
<div class="row">

<div class="col-xs-12 col-md-6"><input type="submit" value="Register" class="btn btn-primary btn-block btn-lg" tabindex="7"></div>

<div class="col-xs-12 col-md-6"><a href="login" class="btn btn-success btn-block btn-lg">Log in</a></div>
	
</div>
	</form:form>
	</div>
</div>
<!-- Modal -->
<div class="modal fade" id="t_and_c_m" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">

<div class="modal-content">

<div class="modal-header">

<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>

<h4 class="modal-title" id="myModalLabel">Terms & Conditions</h4>
</div>
</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</div>
<%@include file="common-footer.jsp" %>
</body>
</html>