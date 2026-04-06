<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="text-center">ListProduct</h1>

    <table class="table table-bordered table-striped">
        <tr>
            <th>ProductId</th>
            <th>ProductName</th>
            <th>Producer</th>
            <th>Year</th>
            <th>Date</th>
            <th>Price</th>
        </tr>

        <c:forEach var="p" items="${products}">
            <tr>
                <td>${p.proId}</td>
                <td>${p.proName}</td>
                <td>${p.producer}</td>
                <td>${p.yearMarking}</td>
                <td>${p.expiryDate}</td>
                <td>${p.price}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
