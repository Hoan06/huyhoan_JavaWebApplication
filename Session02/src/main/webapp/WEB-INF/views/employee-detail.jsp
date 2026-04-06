<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<html>
<body>
<%@ include file="header.jsp" %>
<h3>Chi tiết nhân viên: <c:out value="${employee.fullName}"/></h3>
<ul>
  <li>Mã: ${employee.code}</li>
  <li>Phòng ban: ${employee.department}</li>
  <li>Lương:
    <c:choose>
      <c:when test="${sessionScope.role == 'hr_manager'}">
        <fmt:formatNumber value="${employee.salary}" type="currency" currencySymbol="VNĐ"/>
      </c:when>
      <c:otherwise>*** (Bạn không có quyền xem)</c:otherwise>
    </c:choose>
  </li>
</ul>
<a href="<c:url value='/employees'/>">Quay lại danh sách</a>
</body>
</html>