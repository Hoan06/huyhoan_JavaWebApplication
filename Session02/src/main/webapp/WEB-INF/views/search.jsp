<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Tìm kiếm sự kiện</title>
    <style>
        .sold-out { color: red; font-weight: bold; }
        .low-stock { color: orange; }
        .available { color: green; }
        .badge-free { background-color: #28a745; color: white; padding: 3px 7px; border-radius: 4px; }
        .disabled-link { color: gray; pointer-events: none; text-decoration: none; }
    </style>
</head>
<body>

<section>
    <h2>Kết quả tìm kiếm cho: <c:out value="${keyword}" /></h2>
    <p>Tìm thấy ${fn:length(events)} sự kiện.</p>

    <c:if test="${empty events}">
        <div class="alert">Không tìm thấy sự kiện nào phù hợp.</div>
    </c:if>
</section>

<c:if test="${not empty events}">
    <table border="1" cellpadding="10" style="border-collapse: collapse; width: 100%;">
        <thead>
        <tr style="background-color: #eee;">
            <th>STT</th>
            <th>Tên sự kiện</th>
            <th>Ngày tổ chức</th>
            <th>Giá vé</th>
            <th>Vé còn lại</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="event" items="${events}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td><c:out value="${event.name}" /></td>
                <td>${event.date}</td>
                <td>
                    <c:choose>
                        <c:when test="${event.price == 0}">
                            <span class="badge-free">MIỄN PHÍ</span>
                        </c:when>
                        <c:otherwise>
                            <fmt:formatNumber value="${event.price}" type="number" groupingUsed="true" /> VNĐ
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${event.remainingTickets == 0}">
                            <span class="sold-out">HẾT VÉ</span>
                        </c:when>
                        <c:when test="${event.remainingTickets < 10}">
                            <span class="low-stock">Sắp hết (còn ${event.remainingTickets} vé)</span>
                        </c:when>
                        <c:otherwise>
                            <span class="available">${event.remainingTickets}</span>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:url var="bookUrl" value="/events/${event.id}/book" />
                    <c:choose>
                        <c:when test="${event.remainingTickets > 0}">
                            <a href="${bookUrl}">Đặt vé</a>
                        </c:when>
                        <c:otherwise>
                            <span class="disabled-link">Đặt vé</span>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<footer style="margin-top: 30px; border-top: 1px solid #ccc; padding-top: 10px;">
    <c:if test="${not empty events}">
        <p>Sự kiện nổi bật nhất:
            <strong>${fn:toUpperCase(events[0].name)}</strong>
        </p>
    </c:if>
    <p>Độ dài từ khóa tìm kiếm: ${fn:length(keyword)} ký tự.</p>
</footer>

</body>
</html>