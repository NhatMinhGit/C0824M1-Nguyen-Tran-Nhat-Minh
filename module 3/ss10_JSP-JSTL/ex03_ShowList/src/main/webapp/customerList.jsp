<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Danh sách khách hàng</title>
</head>
<body>

<h2>Danh sách khách hàng</h2>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Date of Birth</th>
        <th>Address</th>
        <th>Image</th>
    </tr>
    <c:forEach var="customer" items="${list}">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.dateOfBirth}</td>
            <td>${customer.address}</td>
            <td><img src="${customer.image}" alt="Customer Image" width="100"></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
