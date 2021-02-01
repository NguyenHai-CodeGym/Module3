<%--
  Created by IntelliJ IDEA.
  User: Hai
  Date: 1/29/2021
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/display-discount">
    <h2> Product Discount Calculator</h2>
    <label>Product Description: </label><br/>
    <input type="text" name="Description" placeholder="Description"><br/>
    <labe>List Price:</labe><br/>
    <input type="text" name="ListPrice" placeholder="Price"><br/>
    <label>Discount Percent: </label><br/>
    <input type="text" name="DiscountPercent" placeholder="Discount Percent" value="%"> <br/>
    <input type = "submit" id = "submit" value = "Calculate Discount"/>
</form>
</body>
</html>
