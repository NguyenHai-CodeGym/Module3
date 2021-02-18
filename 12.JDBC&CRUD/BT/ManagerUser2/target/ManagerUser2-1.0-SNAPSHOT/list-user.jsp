<%--
  Created by IntelliJ IDEA.
  User: Hai
  Date: 2/10/2021
  Time: 4:39 PM
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

    <title>Title</title>
</head>
<body>
<div class="container">
    <h2>List User</h2>
    <a href="/addUser">Create New User</a>
    <table class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th colspan="2">Action</th>
        </tr>
        <c:forEach items="${users}" var="users">
            <tr>
                <td>${users.id}</td>
                <td>${users.name}</td>
                <td>${users.email}</td>
                <td>${users.country.countryName}</td>
                <td><a href="/deleteUser?id=${users.id}">DELETE</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
