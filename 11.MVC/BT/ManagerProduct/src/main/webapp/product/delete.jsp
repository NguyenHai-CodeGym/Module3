
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Delete Product</h1>
<p>
    <a href="/product">Back to customer list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${requestScope["products"].getNameProduct()}</td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>${requestScope["products"].getPrice()}</td>
            </tr>
            <tr>
                <td>Quantity: </td>
                <td>${requestScope["products"].getQuantity()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete product"></td>
                <td><a href="/product">Back to customer list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
