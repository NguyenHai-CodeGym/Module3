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
    <h2 style="text-align: center">List Post</h2><br><br>
    <a href="/addPost">Create New Post</a>
    <p style="color: green">${mess}</p>
    <table class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Short Content</th>
            <th>Publish Date</th>
            <th>image</th>
            <th>Category</th>
            <th colspan="2">Action</th>
        </tr>
        <c:forEach var="list" items='${list}'>
            <tr>
                <td>${list.id}</td>
                <td>${list.title}</td>
                <td>${list.shortContent}</td>
                <td>${list.publishDate}</td>
                <td><img src="${list.image}" alt="" style="height: 100px;"></td>
                <td>${list.category.nameCategory}</td>
                <td><a href="/editPost?id=${list.id}">EDIT</a></td>
                <td><a href="/deletePost?id=${list.id}">DELETE</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
