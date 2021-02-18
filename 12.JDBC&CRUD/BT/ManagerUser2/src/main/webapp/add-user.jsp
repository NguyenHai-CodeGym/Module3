<%--
  Created by IntelliJ IDEA.
  User: Hai
  Date: 2/10/2021
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
            crossorigin="anonymous"></script>

    <title>Create New User</title>
</head>
<body>
<div class="container">
    <h2>Create New User</h2>
    <a href="/listUser">Back Menu</a>
    <p style="color: green">${mess}</p>
    <form action="/addUser" method="post">
        <div class="form-group">
            <label>Name:</label>
            <input type="text" class="form-control" name="name">
        </div>
        <div class="form-group">
            <label>Email:</label>
            <input type="email" class="form-control" name="email">
        </div>
        <div class="form-group">
            <label for="sel1">Country</label>
            <select class="form-control" id="sel1", name="Country">
               <c:forEach var="countries" items="${countries}">
                   <option value="${countries.id}">${countries.countryName}</option>
               </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
