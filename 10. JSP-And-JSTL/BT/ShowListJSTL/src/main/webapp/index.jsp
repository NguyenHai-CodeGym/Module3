<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.hai.Customer" %><%--
  Created by IntelliJ IDEA.
  User: Hai
  Date: 2/1/2021
  Time: 8:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
            List<Customer> list = new ArrayList<>();
            list.add(new Customer("Thang","1/1/1998","Quang Binh","https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MXx8aHVtYW58ZW58MHx8MHw%3D&ixlib=rb-1.2.1&w=1000&q=80"));
            list.add(new Customer("Hai","1/1/1998","Hue","https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MXx8aHVtYW58ZW58MHx8MHw%3D&ixlib=rb-1.2.1&w=1000&q=80"));
            list.add(new Customer("Thinh","1/1/1998","Hue","https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MXx8aHVtYW58ZW58MHx8MHw%3D&ixlib=rb-1.2.1&w=1000&q=80"));
    %>
    <h2>Danh Sách Khách Hàng</h2>

    <table style="border: 1px solid">
        <tr>
            <th>Name</th>
            <th>Date Of Birth</th>
            <th>Address</th>
            <th>Image</th>
        </tr>

                <c:forEach var="customer" items="<%=list%>" >
        <tr>
                <td>${customer.name}</td>
                <td>${customer.dayOfBirth}</td>
                <td>${customer.dayOfBirth}</td>
                <td><img src="${customer.image}" alt="" style="width: 100px; height: 100px"></td>
        </tr>
            </c:forEach>
    </table>

</body>
</html>
