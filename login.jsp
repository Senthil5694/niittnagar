<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Login</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
body { 
  background: url(http://lorempixel.com/1920/1920/city/9/) no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
 
 background-size: cover;
}

.panel-default {
opacity: 0.9;
margin-top:20px;
}
.form-group.last { margin-bottom:0px; }
</style>
</head>
<%@include file="header.jsp" %>
<body>
<h1>${msg}</h1>
<div class="container">

    <div class="row">
   
     <div class="col-md-4 col-md-offset-7">
           
 <div class="panel panel-default">
       
         <div class="panel-heading">
                   
 <span class="glyphicon glyphicon-lock">
</span> Login</div>
   
             <div class="panel-body">
          
          <form:form action="perform_login" method="post" class="form-horizontal" role="form">
    
                <div class="form-group">
        
                <label for="inputEmail3" class="col-sm-3 control-label">
 
                           Username</label>
   
                     <div class="col-sm-9">
   
                         <input type="text" class="form-control"  name="username"  required="true" placeholder="username" required>
  
                      </div>
                   
 </div>
                   
 <div class="form-group">
           
             <label for="inputPassword3" class="col-sm-3 control-label">
   
                         Password</label>
                        <div class="col-sm-9">
  
                          <input type="password" class="form-control"  name="password"  required="true" placeholder="Password" required>
  
                      </div>
                    </div>
                    <div class="form-group">
    
                    <div class="col-sm-offset-3 col-sm-9">
        
                    <div class="checkbox">
                           
     <label>
                                  
  <input type="checkbox"/>
                              
      Remember me
                          
      </label>
                            </div>
    
                    </div>
  
                  </div>
                    <div class="form-group last">
 


                       <div class="col-sm-offset-3 col-sm-9">
        
                    <button type="submit" class="btn btn-success btn-sm">
       
                         Log in</button>
                                
 <button type="reset" class="btn btn-default btn-sm">
                      
          Reset</button>
                        </div>
               
     </div>
                    </form:form>
                </div>
                <div class="panel-footer">
                    Not Registred? <a href="register">Register here</a></div>
            </div>
        </div>
    </div>
</div>

</body>
<%@include file="footer.jsp" %>
</html>