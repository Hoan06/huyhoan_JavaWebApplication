<%@ page contentType="text/html;charset=UTF-8" %>

<h2> Chi tiết sinh viên</h2>

<p><b>Mã SV:</b> ${student.id}</p>
<p><b>Họ tên:</b> ${student.fullName}</p>
<p><b>Khoa:</b> ${student.faculty}</p>
<p><b>Năm nhập học:</b> ${student.enrollmentYear}</p>
<p><b>GPA:</b> ${student.gpa}</p>
<p><b>Trạng thái:</b> ${student.status}</p>

<br>
<a href="/students"> Quay lại danh sách</a>