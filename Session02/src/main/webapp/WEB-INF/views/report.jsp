<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Báo cáo điểm</title>
    <style>
        table { width: 100%; border-collapse: collapse; }
        th, td { padding: 10px; border: 1px solid #ccc; text-align: center; }
        .rank-high { color: green; font-weight: bold; }
        .rank-low { color: red; }
    </style>
</head>
<body>

<c:set var="userView" value="${sessionScope.userView + 1}" scope="session" />

<h1>${reportTitle}</h1>
<p>Số lần bạn đã xem báo cáo này: <strong>${sessionScope.userView}</strong></p>

<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Họ tên</th>
        <th>Điểm</th>
        <th>Xếp loại</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="sv" items="${studentList}" varStatus="loop">
        <tr>
            <td>${loop.index + 1}</td>
            <td><c:out value="${sv.fullName}" /></td>
            <td>${sv.score}</td>
            <td>
                <c:choose>
                    <c:when test="${sv.score >= 90}"><span class="rank-high">Xuất sắc</span></c:when>
                    <c:when test="${sv.score >= 80}">Giỏi</c:when>
                    <c:when test="${sv.score >= 70}">Khá</c:when>
                    <c:when test="${sv.score >= 50}">Trung bình</c:when>
                    <c:otherwise><span class="rank-low">Yếu</span></c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>