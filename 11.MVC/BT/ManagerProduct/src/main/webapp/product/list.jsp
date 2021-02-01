<%--
  Created by IntelliJ IDEA.
  User: Hai
  Date: 2/1/2021
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<h1>Product</h1>
<p>
    <a href="/product?action=create">Create new Product</a>
</p>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Price</td>
        <td>Quantity</td>
    </tr>
    <c:forEach items='${products}' var="product">
        <tr>
            <td><a href="/product?action=view&id=${product.getId()}">${product.getNameProduct()}</a></td>
            <td>${product.getPrice()}</td>
            <td>${product.getQuantity()}</td>
            <td><a href="/product?action=edit&id=${product.getId()}">edit</a></td>
            <td><a href="/product?action=delete&id=${product.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
