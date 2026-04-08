<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
    <style>
        body { font-family: sans-serif; padding: 20px; }
        .info { color: blue; font-weight: bold; }
        .success { color: green; }
    </style>
</head>
<body>
<h2>Kết quả tìm kiếm thực đơn</h2>
<p class="success">${msg}</p>

<ul>
    <li>Loại món ăn: <span class="info">${cateName}</span></li>
    <li>Số lượng hiển thị: <span class="info">${pageSize}</span></li>
</ul>

<hr>
<p><i>Hệ thống đang liệt kê danh sách các món ăn thuộc nhóm ${cateName}...</i></p>
</body>
</html>