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
    <h1 class="text-center">Danh sách sinh viên</h1>

    <a href="/students?sortBy=name">Sắp xếp theo tên</a>
    <a href="/students?sortBy=gpa">Sắp xếp theo gpa</a>
    <a href="/students/dashboard">DashBoard</a>

    <table class="table table-bordered table-striped">
        <tr>
            <th>STT</th>
            <th>Id</th>
            <th>Tên sinh viên</th>
            <th>Khoa</th>
            <th>Tuyển sinh năm</th>
            <th>Gpa</th>
            <th>Trạng thái</th>
            <th>Chi tiết</th>
        </tr>

        <c:forEach var="s" items="${students}" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <td>${s.id}</td>
                <td>${s.fullName}</td>
                <td>${s.faculty}</td>
                <td>${s.enrollmentYear}</td>
                <td>${s.gpa}</td>
                <td>
                    <c:choose>
                        <c:when test="${s.status == 'Đang học'}">
                            <span style="color:green;">Đang học</span>
                        </c:when>
                        <c:when test="${s.status == 'Cảnh cáo'}">
                            <span style="color:orange;">Cảnh cáo</span>
                        </c:when>
                        <c:when test="${s.status == 'Đã tốt nghiệp'}">
                            <span style="color:blue;">Đã tốt nghiệp</span>
                        </c:when>
                        <c:otherwise>
                            <span style="color:gray;">${s.status}</span>
                        </c:otherwise>
                    </c:choose>
                </td>

                <td>
                    <a href="${pageContext.request.contextPath}/students/detail?id=${s.id}">Chi tiết</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
