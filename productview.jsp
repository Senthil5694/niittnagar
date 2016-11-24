<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<title>products</title>
</head>
<body>
<%@include file="userheader.jsp" %>
<center>
<h1>Dell brand laptops</h1>
</center>
<div class="dell-brand" ng-app="addToCartApp" ng-controller="addToCartCtrl">
<div class="container">
  <div class="row">
  <c:forEach items="${productList}" var="product">
     <div class="col-sm-4">
      <h3>${product.name}</h3>
      <img src="F:\tronicsville/${product.pid}.jpg">
<h3>price=Rs.${product.price}</h3>
<span class="glyphicon glyphicon-shopping-cart"></span>
<button class="btn btn-primary" ng-click="additemtocart('${product.pid}')" class="btn btn-info" >AddToCart</button>
    </div>
    </c:forEach>
    </div>
    </div>
    </div>
    <script>
 var cartApp = angular.module ("addToCartApp", []);

 cartApp.controller("addToCartCtrl", function ($scope, $http){
 	
     $scope.retrieveCart = function (cartid) {
         $scope.cartid = cartid;
         $scope.refreshCartItems(cartid);
     };
     
     $scope.removeItemFromCart = function (cartitemid) {
         $http.put('http://localhost:8080/tronics/usercart/cart/removeitem/'+cartitemid).success(function (data) {
             $scope.refreshCartItems();
         });
     };

      $scope.additemtocart = function (pid) {
         $http.put('http://localhost:8080/tronics/usercart/cart/additem/'+pid).success(function (data) {
             alert("Item added to the cart!")
         });
     };
      
       $scope.GrandTotalOfItems = function () {
         var grandTotal=0;

         for (var i=0; i<$scope.cart.cartItems.length; i++) {
             grandTotal+=$scope.cart.cartItems[i].totalPrice;
        }

         return grandTotal;
     };
    
     $scope.refreshCartItems = function () {
         $http.get('http://localhost:8080/tronics/usercart/cart/refreshCart/'+$scope.cartid).success(function (data) {
            $scope.cart=data;
         });
     };
     
     
     $scope.clearCartItems = function () {
     	$http['delete']('http://localhost:8080/tronics/usercart/cart/clearCartItems/'+$scope.cartid).success(function (data)
     			{$scope.refreshCartItems()
     		});
     };
 });



</script>
   

</body>
<%-- <%@include file="common-footer.jsp" %> --%>
</html>