<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.grouptwelve.valleystealz.models.Product" %>
<%@ page import="com.grouptwelve.valleystealz.services.ProductService" %>

<%@ page import="java.util.List" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Valley Stealz</title>
    <link rel="stylesheet" href="/css/showCart.css">
    <link rel="stylesheet" href="/css/index.css">
    <link rel="apple-touch-icon" sizes="180x180" href="/images/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/images/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/images/favicon-16x16.png">
    <link rel="manifest" href="/images/site.webmanifest">
    <link rel="mask-icon" href="/images/safari-pinned-tab.svg" color="#5bbad5">
</head>
<body>

<div class="home">

  <video autoplay loop muted plays-inline class="back-video">
    <source src="images/FinalPromoVideo.mp4" type="video/mp4">
  </video>

  <nav>
    <a href="/"><img src="https://i.ibb.co/ng4cSgp/White.png" class="logo"></a>
      <ul>
          <li><a href="/">Home</a></li>
          <!-- Implement For Each in Products -->
          <!-- And Provide Links -->
          <li><a href="/products">Products</a></li>

          <li><a href="/logout">Logout</a></li>

          <li><a href="/cart"><img src="https://cdn-icons-png.flaticon.com/512/1170/1170678.png" style="width: 20px"/></a></li>
      </ul>
  </nav>

    <!-- Display a table of items in the cart -->
    <table>
        <tr>
            <th>Image</th>
            <th>Name</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Delete</th>
        </tr>

        <c:forEach items="${user.userProducts}" var="item">
            <tr>
                <td><img src="${productService.findProduct(item.productId).imgSource}" width="50" height="50" /></td>
                <td>${productService.findProduct(item.productId).name}</td>
                <td>${item.quantity}</td>
                <td>${productService.findProduct(item.productId).price}</td>
                <td><button onclick="window.location='/deleteFromCart/${item.id}'">Delete</button></td>
            </tr>
        </c:forEach>
    </table>

    <!-- Display the subtotal at the bottom of the table -->
<%--    <p class="subtotal">Subtotal: ${fn:formatNumber(cart.subtotal, '#,##0.00')}</p>--%>
</div>
</body>
</html>

