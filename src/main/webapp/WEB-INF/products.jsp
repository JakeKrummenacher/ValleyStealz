<%@ page import="com.grouptwelve.valleystealz.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Products</title>
<%--  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">--%>
  <link rel="stylesheet" href="/css/products.css">
  <!-- change to match your file/naming structure -->
  <script src="/webjars/jquery/jquery.min.js"></script>
<%--  <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>--%>
  <link rel="stylesheet" href="css/index.css">
  <link rel="apple-touch-icon" sizes="180x180" href="/images/apple-touch-icon.png">
  <link rel="icon" type="image/png" sizes="32x32" href="/images/favicon-32x32.png">
  <link rel="icon" type="image/png" sizes="16x16" href="/images/favicon-16x16.png">
  <link rel="manifest" href="/images/site.webmanifest">
  <link rel="mask-icon" href="/images/safari-pinned-tab.svg" color="#5bbad5">
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

<div class="container">
  <div class="product-grid">
    <%
      List<Product> products = (List<Product>) request.getAttribute("products");
      for (Product product : products) {
    %>
    <div class="product-card" onclick="window.location='/products/<%=product.getId()%>'">
      <img src="<%= product.getImgSource() %>" alt="<%= product.getName() %>">
      <h3><%= product.getName() %></h3>
      <p>$<%= product.getPrice() %></p>
    </div>
    <% } %>
  </div>
</div>

</body>
</html>