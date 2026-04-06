<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<nav style="background: #333; color: #fff; padding: 10px;">
  <strong>HR Portal</strong> | Xin chào, <c:out value="${sessionScope.loggedUser}"/> (${sessionScope.role})
  <a href="<c:url value='/employees'/>" style="color:white; margin-left:20px;">Danh sách</a>
  <c:if test="${sessionScope.role == 'hr_manager'}">
    <a href="#" style="color:white; margin-left:10px;">Báo cáo lương</a>
  </c:if>
  <a href="<c:url value='/logout'/>" style="color:red; float:right;">Đăng xuất</a>
</nav>