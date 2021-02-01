<%--
  Created by IntelliJ IDEA.
  User: Hai
  Date: 2/1/2021
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create new product<</title>
</head>
<body>
    <h1>Create new Product</h1>
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span>
        </c:if>
    </p>
    <p><a href="/product">Back To Product List</a></p>
    <form method="post">
        <fieldset>
            <legend>Product</legend>
            <table>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name" id="name" value="${requestScope["products"].getNameProduct()}"></td>
                </tr>
                <tr>
                    <td>Price: </td>
                    <td><input type="number" name="price" id="price" value="${requestScope["products"].getPrice()}"></td>
                </tr>
                <tr>
                    <td>Quantity: </td>
                    <td><input type="number" name="quantity" id="quantity" value="${requestScope["products"].getQuantity()}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Update product"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>
