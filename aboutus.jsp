<doctypehtml>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tronicsville</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
h1
{
margin:0px;
text-align:center;
}
.carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
}
ul.menu-new {margin: 0px; width: 100%; text-align: center; display: inline-block; padding: 15px;}
ul.menu-new li {text-align: center; display: inline-block; position: relative;}
ul.menu-new li a {color: #ffffff; text-decoration: none; padding: 10px 15px; display:block; text-transform: uppercase;}
ul.menu-new li a:hover {color: #ffffff; text-decoration: none; background: #111111;}
ul.menu-new li ul.drop {display: none; z-index: 999999999; position: absolute; left: 00px; top: 40px;}
ul.menu-new li ul.drop li {width:210px; display:block; text-align:left;}
ul.menu-new li:hover ul.drop {display: block;}

 figure.img img {max-width:500%;margin-top:60px;} 
[class*='col-'] {padding:15px;}

ul
{
margin:0px;
padding:0px;
}
ul li
{ 
margin:0px;
background-color:lightgreen;
border:1px solid white;
display:inline-block;
text-align:center;
list-style:none;
}
ul li a
{
color:white;
text-decoration:none;
dispaly:block;
}
ul li a:hover
{
background-color:red;
}
.icons
{
margin:0px;
float:right;
}
ul.icons li
{
display:inline-block;
}
.about{
padding-left:100px;
}
</style>
</head>
<body bgcolor=lightgreen>
<img src="F:\project\E-commerce project/tronics.png" width="100" height="50"/>
<ul class="icons">
<li><a href="https://www.facebook.com" target="blank"><img src="F:\project\E-commerce project/facebook.png" height="30"/></a></li>
<li><a href="https://plus.google.com" target="blank"><img src="F:\project\E-commerce project/googleplus.png" height="30"/></a></li>
<li><a href="https://www.linkedin.com" target="blank"><img src="F:\project\E-commerce project/linkedin.png" height="30"/></a></li>
<li><a href="https://twitter.com" target="blank"><img src="F:\project\E-commerce project/twitter.png" height="30"/></a></li>
</ul>
<h1>Tronicsville</h1>
<hr>
<ul class="menu-new">
<li><a href="aboutus">about us</a></li>
<li><a href="contactus">contact us</a></li>
<li><a href="#"> products</a>
<ul class="drop">
<li><a href="mobiles">mobiles</a></li>
<li><a href="laptops">laptops</a></li>
<li><a href="#">tabs</a></li>
<li><a href="#">home appliances</a></li>
</ul>
</li>
<li><a href="login">signin</a></li>
<li><a href="register">register</a></li>
</ul>
<hr>
<div id="container">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="F:\project\E-commerce project/laptop-1.jpg" alt="laptop">
    </div>

    <div class="item">
      <img src="F:\project\E-commerce project/laptop-2.jpg" alt="laptop">
    </div>

    <div class="item">
      <img src="F:\project\E-commerce project/smartphone-1.jpg" alt="smartphone">
    </div>

    <div class="item">
      <img src="F:\project\E-commerce project/smartphone-2.jpg" alt="smartphone">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</div>
<div class="about">
<p>Dear Customers and visitors, I am pleased to welcome you to our website. 
The inception of Tronicsville is to impart shopping in the most simple, 
interesting way at affordable prices.</p>
<br>
<p>Senthil kumar</p>
<p>Founder And CEO-Tronicsville</p>
<h4 style="color:#ff3e96">About Website</h4>
<p>Tronics ville is an eletronics items selling website which has a wide variety of electronics in all top brands at a resonable price.</p>
<h4 style="color:#ff3e96">About Company</h4>
<p>The company was started on january 6 2016 which has its headquarters in chennai,tamilnadu</
</div>
<%@include file="footer.jsp" %>
</body>
</html>