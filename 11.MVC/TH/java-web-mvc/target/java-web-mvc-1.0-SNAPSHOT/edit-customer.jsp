<%--
  Created by IntelliJ IDEA.
  User: Hai
  Date: 2/2/2021
  Time: 2:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Customer</title>
</head>
<body>
<h1>Edit Customer</h1><br>
<p><a href="/customers">Danh Sach</a></p><br>
<%--<c:if test='${requestScope["mess"]!= null}'>--%>
<%--    <span style="color: green">${requestScope["mess"]}</span>--%>
<%--</c:if>--%>
<h2 style="color:green;">${mess}</h2>
<form action="editCustomer?id=${customer.id}" method="post">
    <label>Name</label></br>
    <input type="text" name="name" value='${customer.name}'><br>
    <label>Email</label></br>
    <input type="email" name="email" value='${customer.email}'><br>
    <label>Address</label></br>
    <input type="text" name="address" value='${customer.address}'><br>
    <label>Country</label><br>
    <select name="country" id="country">
        <c:forEach var="country" items='${countries}'>
            <c:if test='${country.id == customer.province.id}'>
                <option value='${country.id}' selected>${country.province}</option>
            </c:if>
            <c:if test='${country.id != customer.province.id}'>
                <option value='${country.id}'>${country.province}</option>
            </c:if>

        </c:forEach>
    </select><br>
    <input type="reset" name="Reset" value="Reset"><input type="submit" name="Submit" value="Submit"><br>
</form>
</body>
</html>
