Phần 1: Phân tích logic
Nguyên nhân khiến giỏ hàng luôn trống khi sang trang /checkout nằm ở việc sử dụng HttpServletRequest để lưu trữ dữ liệu giữa hai yêu cầu khác nhau.

Cơ chế của HttpServletRequest: Đối tượng request chỉ có vòng đời trong một lần gọi HTTP duy nhất. Khi người dùng gửi dữ liệu lên /add-to-cart, một request được tạo ra, dữ liệu được lưu vào đó, nhưng ngay khi server gửi phản hồi (response) về trình duyệt, đối tượng request này sẽ bị hủy bỏ.

Tác động của lệnh Redirect: Khi bạn sử dụng return "redirect:/checkout", server sẽ gửi mã trạng thái HTTP 302 yêu cầu trình duyệt thực hiện một lệnh gọi GET hoàn toàn mới đến đường dẫn /checkout. Tại thời điểm này, một request mới (trống rỗng) được tạo ra. Do đó, lệnh request.getAttribute("myCart") ở phương thức viewCheckout sẽ luôn trả về null.

Kết luận: Lỗi do việc chọn sai công cụ lưu trữ. HttpServletRequest không có khả năng duy trì dữ liệu xuyên suốt các phiên làm việc (Session) của người dùng.