<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
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
    <h2>Create New Post</h2>
    <p style="color: green">${mess}</p>
    <a href="/listPost">Back Menu</a>
    <form action="/addPost" method="post">
        <label for="usr">Title:</label>
        <input type="text" class="form-control" id="usr" name="title"><br>
        <label>Full Content: </label>
        <textarea class="form-control" name="fullContent" rows="4" cols="50" placeholder="shortContent..." required>
    </textarea>
        <br>
        <label>shortContent</label>
        <textarea class="form-control" name="shortContent" rows="4" cols="50" placeholder="shortContent..." required>
    </textarea>
        <br>
        <div class="form-group">
            <label for="usr">Image:</label>
            <input type="text" class="form-control" name="image">
        </div>
        <div class="form-group">
            <label for="usr">Category</label>
            <select name="category" id="categoryId" class="form-control">
                <option>-----Vui Lòng Chọn Thể Loại------</option>
                <c:forEach var="cateList" items='${cateList}'>
                    <option value='${cateList.id}'>${cateList.nameCategory}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>