<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<html>
<head><title>Danh sách nhân viên</title></head>
<body>
<%@ include file="header.jsp" %>

<h2>Danh sách nhân sự</h2>
<table border="1" width="100%">
    <tr>
        <th>STT</th><th>Mã NV</th><th>Họ tên</th><th>Phòng ban</th><th>Lương</th><th>Ngày vào</th><th>Trạng thái</th><th>Thao tác</th>
    </tr>
    <c:forEach var="emp" items="${employees}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td><c:out value="${emp.code}"/></td>
            <td><c:out value="${emp.fullName}"/></td>
            <td>${emp.department}</td>
            <td><fmt:formatNumber value="${emp.salary}" type="currency" currencySymbol="VNĐ"/></td>
            <td><fmt:formatDate value="${emp.joinDate}" pattern="dd/MM/yyyy"/></td>
            <td>
                <c:choose>
                    <c:when test="${emp.status == 'Đang làm'}"><span style="color:green">${emp.status}</span></c:when>
                    <c:when test="${emp.status == 'Nghỉ phép'}"><span style="color:orange">${emp.status}</span></c:when>
                    <c:otherwise><span style="color:blue">${emp.status}</span></c:otherwise>
                </c:choose>
            </td>
            <td><a href="<c:url value='/employees/${emp.code}'/>">Xem chi tiết</a></td>
        </tr>
    </c:forEach>
</table>

<p><strong>Tổng lương phòng Kỹ thuật: </strong>
    <fmt:formatNumber value="${techTotalSalary}" type="currency" currencySymbol="VNĐ"/>
</p>

</body>
</html>