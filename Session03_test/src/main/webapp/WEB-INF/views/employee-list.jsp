<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Danh sách nhân viên</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="text-center">Danh sách nhân viên</h1>

    <table class="table table-bordered table-striped">
        <tr>
            <th>STT</th>
            <th>Id</th>
            <th>Tên nhân viên</th>
            <th>Phòng ban</th>
            <th>Lương</th>
            <th>Đánh giá</th>
        </tr>

        <c:forEach var="e" items="${employees}" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <td>${e.id}</td>
                <td>${e.fullName}</td>
                <td>${e.department}</td>
                <td>${e.salary}</td>
                <td>
                    <c:choose>
                        <c:when test="${e.salary >= 10000}">
                            <span>Mức lương cao</span>
                        </c:when>
                        <c:otherwise>
                            <span>Mức lương cơ bản</span>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
