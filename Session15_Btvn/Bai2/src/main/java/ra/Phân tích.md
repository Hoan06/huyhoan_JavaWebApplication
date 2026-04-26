Phần 1: Phân tích logic
Lý do câu lệnh UPDATE không tác động được vào CSDL dù không báo lỗi là do cơ chế mặc định của Spring Data JPA:

Thiếu @Modifying: Mặc định, các phương thức @Query được thiết kế để thực thi các câu lệnh SELECT. Khi thực hiện các câu lệnh DML (Data Manipulation Language) như UPDATE, DELETE hoặc INSERT, Spring Data JPA yêu cầu phải có Annotation @Modifying để hiểu rằng đây là một truy vấn làm thay đổi dữ liệu, đồng thời giúp hệ thống xử lý việc xóa bộ đệm (clear cache) sau khi thực thi.

Thiếu @Transactional: Các thao tác thay đổi dữ liệu (Update/Delete) bắt buộc phải chạy trong một giao dịch (Transaction). Nếu không có ràng buộc này, lệnh SQL có thể được gửi đi nhưng không được COMMIT xuống Database, dẫn đến dữ liệu không thay đổi.