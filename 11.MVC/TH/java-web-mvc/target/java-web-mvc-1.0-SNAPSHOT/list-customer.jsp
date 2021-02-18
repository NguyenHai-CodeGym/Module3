<%--
  Created by IntelliJ IDEA.
  User: Hai
  Date: 2/2/2021
  Time: 11:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customer</h1>
<a href="/addCustomer">Create Customer</a>
<table border="1px">
    <tr>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>Country</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["customers"]}' var="customer">
    <tr>
        <td>${customer.name}</td>
        <td>${customer.email}</td>
        <td>${customer.address}</td>
        <td>${customer.province.province}</td>
        <td><a href='editCustomer?id=${customer.id}'>Edit</a></td>
        <td><a href="deleteCustomer?id=${customer.id}">Delete</a></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
