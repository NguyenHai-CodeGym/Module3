<%--
  Created by IntelliJ IDEA.
  User: Hai
  Date: 2/1/2021
  Time: 8:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculate" method="post">
    <label>First Operand</label> </br>
    <input type="number" name="first-operand"> </br>
    <select name="operator">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select>
    </br>
    <label>Second Operand</label> </br>
     <input type="number" name="second-operand"> </br>
    <input type="submit" id="submit" value="Calculate">
</form>
</body>
</html>
