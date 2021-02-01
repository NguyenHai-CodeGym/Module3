<%--
  Created by IntelliJ IDEA.
  User: Hai
  Date: 2/1/2021
  Time: 5:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<h1>Edit Product</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p><a href="/product">Back To Product List</a></p>
<form method="post">
    <fieldset>
        <legend>Edit information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${requestScope["products"].getNameProduct()}"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="price" id="price" value="${requestScope["products"].getPrice()}"></td>
            </tr>
            <tr>
                <td>Quantity: </td>
                <td><input type="text" name="quantity" id="quantity" value="${requestScope["products"].getQuantity()}"></td>
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
