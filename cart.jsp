<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <title>Cart</title>
</head>
<body>


<div class="span9 margin-bottom center"> 
					<h3>Items in your cart</h3>
					</div>
<div class="span9 margin-left10" ng-app="addToCartApp"  ng-controller = "addToCartCtrl" ng-init="retrieveCart('${cartid}')">
	 
	 <div class="row margin-left25">
        <table class="table table-bordered table-striped fs13" >
		  <thead>
			  <tr>
				
				<th>Image</th>
				<th class="width110">Product</th>
				<th >Unit Price</th>
				<th>Quantity</th>
				<th>Total Price(in Rs.)</th>
				<th>Remove</th>
			  </tr>
			</thead>
			<tbody>
				<tr ng-repeat = "items in cart.cartItems">
					 	<td class="span1"><img src="F:\tronicsville/${product.pid}.jpg" alt="image"/></td>
						<td>{{items.pname}}</td>
						<td>{{items.price}}</td>
						<td>{{items.quantity}}</td>
						<td>{{items.totalPrice}}</td>
						<td><button class="btn btn-danger btnAction" ng-click="removeItemFromCart('${items.product.pid}')">
							<span class="glyphicon glyphicon-remove"></span>remove</button></td>
					</tr>
			  <tr>
                    <td></td>
                    <td></td>
					<td></td>
                    <td>Grand Total(in Rs.)</td>
                    <td>{{GrandTotalOfItems()}}</td>
                    <td>
                </tr>	  
			</tbody>
		  </table>
<script>
 var cartApp = angular.module ("addToCartApp", []);

 cartApp.controller("addToCartCtrl", function ($scope, $http){
 
     $scope.retrieveCart = function (cartid) {
         $scope.cartid = cartid;
         $scope.refreshCartItems(cartid);
     };
     
     $scope.removeItemFromCart = function (pid) {
         $http.put('http://localhost:8080/tronics/usercart/cart/removeItem/'+pid).success(function (data) {
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

</html>