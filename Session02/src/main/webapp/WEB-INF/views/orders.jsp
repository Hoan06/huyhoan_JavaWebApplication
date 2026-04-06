<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Danh sách đơn hàng</title>
    <style>
        table { width: 80%; border-collapse: collapse; margin: 20px 0; }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        .header { background: #f4f4f4; padding: 10px; }
    </style>
</head>
<body>

<div class="header">
    <h3>Xin chào, ${sessionScope.loggedUser}!</h3>
    <p>Vai trò: <strong>${sessionScope.role}</strong></p>
    <a href="<c:url value='/logout'/>">Đăng xuất</a>
</div>

<h2>${reportTitle}</h2>

<table>
    <thead>
    <tr>
        <th>Mã đơn</th>
        <th>Sản phẩm</th>
        <th>Tổng tiền</th>
        <th>Ngày đặt</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${orderList}">
        <tr>
            <td>${order.id}</td>
            <td>${order.productName}</td>
            <td>
                <fmt:formatNumber value="${order.amount}" type="currency" currencyCode="VND"/>
            </td>
            <td>
                <fmt:formatDate value="${order.orderDate}" pattern="dd/MM/yyyy"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<hr>
<div style="color: blue; font-weight: bold;">
    Tổng lượt xem đơn hàng toàn hệ thống: ${applicationScope.totalViewCount}
</div>

</body>
</html>