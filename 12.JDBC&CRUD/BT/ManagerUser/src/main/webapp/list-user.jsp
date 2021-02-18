<%--
  Created by IntelliJ IDEA.
  User: Hai
  Date: 2/4/2021
  Time: 3:00 PM
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
    <title>List User</title>
</head>
<body>
<div class="container">
    <h2 style="text-align: center">List User</h2>
    <a href="/addUser">Create New User</a><br>
    <a href="/listUser">Sắp Xếp Tăng Dần (Theo Tên)</a><br>
    <a href="/orderByDesc">Sắp Xếp Giảm Dần (Theo Tên)</a><br>
    <form action="/searchUser" method="post">
        <div class="form-group">
            <input type="text" class="form-control" id="usr" name="search" placeholder="Find By Country">
        </div>
        <br>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <table class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th colspan="2">Action</th>
        </tr>
         <c:forEach var="user" items='${users}'>
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.country.countryName}</td>
                <td><a href="/editUser?id=${user.id}">EDIT</a></td>
                <td><a href="/deleteUser?id=${user.id}">DELETE</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
