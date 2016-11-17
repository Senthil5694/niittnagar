<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class="navbar navbar-inverse">
 
 <div class="navbar-header">
    
<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
  
    <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
     
 <span class="icon-bar"></span>
    
  <span class="icon-bar"></span>
   
 </button>
   
 <a class="navbar-brand">Welcome Admin</a>
  </div>
 
 <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
       
         <ul class="nav navbar-nav">
					
<li><a href="categories"><i class="icon-home icon-white"></i> Manage Categories</a></li>
	
				<li class="divider-vertical"></li>
	
				<li><a href="suppliers"><i class="icon-file icon-white"></i>Manage Suppliers</a></li>
	
				<li class="divider-vertical"></li>
					
<li><a href="products"><i class="icon-envelope icon-white"></i> Manage Products</a></li>
			
		<li class="divider-vertical"></li>
                  
	<li><a href="viewcustomers"><i class="icon-signal icon-white"></i> View Customers</a></li>
				
	</ul>
               <div class="pull-right" style="padding-top:5px;">
          
          <ul class="nav pull-right">
                        <li class="dropdown">
 
                       <a href="logout">Logout <b class="caret"></b></a>
    
                        <ul class="dropdown-menu">
                                                          
  <li><a href="logout"><i class="icon-off"></i> Logout</a></li>
                      
      </ul>
                        </li>
                    </ul>   
                </div>
            </div>
    
        
			<!--/.nav-collapse -->
    </div>

</div>
<!--/.navbar -->
</body>
</html>