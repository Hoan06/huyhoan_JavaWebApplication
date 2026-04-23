Phần 1: Phân tích Logic & Lỗ hổng hệ thống
Tại sao đơn hàng bị cập nhật sai?
   Dựa trên đoạn code "hiện trường", vấn đề nằm ở chế độ Auto-commit của Session và việc thiếu kiểm soát biên giới giao dịch.

Thiếu Transaction: Bạn mở một session nhưng không hề gọi session.beginTransaction(). Trong nhiều cấu hình mặc định của Hibernate/JDBC, mỗi lệnh session.update() sẽ được coi là một giao dịch riêng lẻ và tự động commit xuống Database ngay lập tức.

Thứ tự thực thi: 1.  Lệnh order.setStatus("PAID") chạy và dữ liệu được đẩy xuống DB ngay.
RuntimeException xảy ra ngay sau đó.
Luồng xử lý nhảy vào catch, in ra thông báo lỗi rồi kết thúc tại finally.

Hệ quả: Vì lệnh cập nhật Order đã "về đích" trước khi lỗi xảy ra, còn lệnh trừ tiền Wallet chưa kịp chạy, dữ liệu bị mất tính toàn vẹn (Inconsistency).

Vòng đời Transaction đang thiếu gì?
   Để đảm bảo tính ACID (Atomicity, Consistency, Isolation, Durability), bạn đang thiếu 3 bước then chốt:

session.beginTransaction(): Đánh dấu điểm bắt đầu, gom các lệnh SQL vào một "túi" duy nhất.

transaction.commit(): Chỉ khi mọi thứ xong xuôi, mới xác nhận lưu tất cả thay đổi vào DB.

transaction.rollback(): Nếu có bất kỳ lỗi nào ở bất kỳ bước nào, phải hủy bỏ toàn bộ các thay đổi đã thực hiện trong "túi" đó để quay về trạng thái ban đầu.