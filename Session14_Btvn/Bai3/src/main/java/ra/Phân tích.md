Phần 1: Báo cáo phân tích và thiết kế giải pháp
Phân tích bài toán (I/O)
   Input: customerId (Người mua), productId (Sản phẩm - ở đây là iPhone 15), quantity (Số lượng mua, thường là 1).

Output: * Thành công: Đơn hàng được tạo, kho trừ đúng số lượng, phản hồi "Đặt hàng thành công".

Thất bại: Thông báo "Hết hàng" hoặc "Hệ thống đang bận, vui lòng thử lại" (nếu có tranh chấp dữ liệu).

Đề xuất giải pháp: Pessimistic Write Lock (Khóa bi quan)
   Đối với kịch bản Flash Sale (tỉ lệ tranh chấp cực cao trong thời gian cực ngắn), Pessimistic Lock (LockMode.PESSIMISTIC_WRITE) là lựa chọn tối ưu hơn so với Optimistic Lock.

Lý do: Optimistic Lock (@Version) sẽ để tất cả các luồng đọc dữ liệu thoải mái, nhưng chỉ luồng đầu tiên commit thành công, các luồng sau sẽ bị văng Exception và phải retry. Trong Flash Sale, điều này gây áp lực rất lớn cho CPU.

Cơ chế Pessimistic Lock: Khi Luồng A đang đọc số dư kho để kiểm tra, nó sẽ "khóa" dòng dữ liệu đó lại. Luồng B muốn đọc phải xếp hàng đợi. Điều này đảm bảo tại một thời điểm, chỉ một luồng duy nhất được phép kiểm tra và trừ kho.

Thiết kế các bước thực hiện
   Mở Transaction.

Truy vấn Product từ DB kèm theo cơ chế PESSIMISTIC_WRITE.

Kiểm tra điều kiện: if (product.getStock() >= quantity).

Thực thi: * Nếu đủ: Trừ stock sản phẩm -> Lưu Product -> Tạo Order.

Nếu thiếu: Throw Exception "Hết hàng".

Commit Transaction (Lúc này khóa mới được giải phóng cho luồng tiếp theo).

Đóng Session.