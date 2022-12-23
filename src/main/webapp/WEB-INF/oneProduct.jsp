<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Product Details</title>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Valley Stealz</title>
  <link rel="stylesheet" href="/css/index.css">
  <link rel="stylesheet" href="/css/oneProduct.css">
  <link rel="apple-touch-icon" sizes="180x180" href="/images/apple-touch-icon.png">
  <link rel="icon" type="image/png" sizes="32x32" href="/images/favicon-32x32.png">
  <link rel="icon" type="image/png" sizes="16x16" href="/images/favicon-16x16.png">
  <link rel="manifest" href="/images/site.webmanifest">
  <link rel="mask-icon" href="/images/safari-pinned-tab.svg" color="#5bbad5">
  <meta name="msapplication-TileColor" content="#da532c">
  <meta name="theme-color" content="#ffffff">
</head>
<body>
  <nav>
    <a href="/"><img src="https://i.ibb.co/ng4cSgp/White.png" class="logo"></a>
    <ul>
      <li><a href="/">Home</a></li>
      <!-- Implement For Each in Products -->
      <!-- And Provide Links -->
      <li><a href="/products">Products</a></li>

      <c:if test="${loggedInUser != null}">
        <li><a href="/logout">Logout</a></li>
      </c:if>
      <c:if test="${loggedInUser == null}">
        <li><a href="/signin">Login</a></li>
      </c:if>
      <li><a href="/cart"><img src="https://cdn-icons-png.flaticon.com/512/1170/1170678.png" style="width: 20px"/></a></li>
    </ul>
  </nav>
<!-- Product card -->
<div class="product-card">
  <img src="${product.imgSource}" alt="${product.name}">
  <h3>${product.name}</h3>
  <p>$${product.price}</p>
  <button type="button" onclick="addToCart()">Add to Cart</button>
</div>

<!-- Add to cart function -->
<script>
  function addToCart() {
    // Add code to add the product to the cart here
    alert("Product added to cart!");
  }
</script>
</body>
</html>