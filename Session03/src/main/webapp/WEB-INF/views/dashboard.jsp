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
    <h1 class="text-center">Thống kê</h1>

    <h4>Tổng số sinh viên : ${total}</h4>
    <h4>GPA trung bình : ${avgGpa}</h4>

    <h4>Thủ khoa : ${topStudent}</h4>
    <h3>Tỉ lệ trạng thái</h3>
    <ul>
        <c:forEach var="entry" items="${statusPercent}">
            <li>${entry.key}: ${entry.value}%</li>
        </c:forEach>
    </ul>

    <a href="/students"> Quay lại danh sách</a>
</div>
</body>
</html>
