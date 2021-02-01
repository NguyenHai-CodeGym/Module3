<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hai
  Date: 2/1/2021
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${error}
<a href="/index">HOME</a>
    <c:forEach var="person" items="${list}">
        <li><a href="/index?id=${person.getId()}">${person.getName()}</a></li>
    </c:forEach>
</body>
</html>
