<%--
  Created by IntelliJ IDEA.
  User: Hai
  Date: 2/4/2021
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
            crossorigin="anonymous"></script>
    <title>Edit User</title>
</head>
<body>
    <div class="container">
        <h2>Edit User</h2>
        <a href="/listUser">Back Menu</a>
        <p style="color: green">${mess}</p>
        <form action="/editUser" method="post">
            <div class="form-group">
                <label for="usr">Name:</label>
                <input type="hidden" name="id" value="${user.id}">
                <input type="text" class="form-control" id="usr" name="name" value="${user.name}">
            </div>
            <div class="form-group">
                <label for="usr">Email:</label>
                <input type="email" class="form-control" name="email" value="${user.email}">
            </div>
            <div class="form-group">
                <label for="usr">Country</label>
                <select name="CountryName" id="CountryId" class="form-control">
                    <c:forEach var="country" items="${countries}">
                        <c:if test="${user.country.countryID == country.countryID}">
                            <option value="${user.country.countryID}" selected>${country.countryName}</option>
                        </c:if>
                        <c:if test="${user.country.countryID != country.countryID}">
                            <option value="${country.countryID}">${country.countryName}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</body>
</html>
