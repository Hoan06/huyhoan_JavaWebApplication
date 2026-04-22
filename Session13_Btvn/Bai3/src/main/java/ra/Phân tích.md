Phần 1: Phân tích nguyên nhân
Tại sao thiếu CascadeType.ALL gây ra lỗi TransientObjectException?
   Trong Hibernate, một đối tượng được gọi là Transient khi nó mới được khởi tạo bằng từ khóa new và chưa được liên kết với một Session nào (chưa có trong database).

Vấn đề: Khi bạn lưu Prescription (Đơn thuốc), đối tượng này chứa một danh sách PrescriptionDetail (Chi tiết). Nếu không có Cascade, Hibernate chỉ cố gắng lưu bản ghi vào bảng Đơn thuốc. Khi nó thấy danh sách chi tiết đang ở trạng thái "Transient" (chưa lưu), nó sẽ tung ra lỗi vì không biết phải làm gì với những đối tượng "con" chưa có ID này.

Vai trò của Cascade: CascadeType.ALL ra lệnh cho Hibernate: "Khi tôi thực hiện bất kỳ hành động nào (Save, Update, Delete) lên Đơn thuốc, hãy tự động thực hiện hành động tương tự lên tất cả các Chi tiết bên trong nó".

Tại sao nên dùng FetchType.LAZY cho danh sách chi tiết thuốc?
   Hiệu năng (Performance): Một đơn thuốc có thể có rất nhiều dòng thuốc. Nếu dùng EAGER, mỗi khi bạn lấy thông tin đơn thuốc (chỉ để xem tên bệnh nhân, ngày kê), Hibernate sẽ tự động thực hiện các lệnh JOIN hoặc truy vấn thêm để lấy toàn bộ danh sách chi tiết. Điều này gây tốn bộ nhớ và giảm tốc độ xử lý.

LAZY Loading: Hibernate chỉ tải danh sách chi tiết thuốc lên khi bạn thực sự gọi hàm getDetails(). Điều này giúp ứng dụng chạy nhẹ nhàng hơn, chỉ lấy dữ liệu khi thực sự cần thiết.
Phần 3: Sơ đồ luồng dữ liệu khi thực hiện session.persist(prescription)
Khi bạn gọi lệnh lưu, Hibernate sẽ thực hiện các bước kiểm tra trạng thái của object như sau:

Bắt đầu: Ứng dụng gọi session.persist(prescription).

Kiểm tra Prescription: Hibernate kiểm tra ID. Nếu ID trống, nó chuẩn bị lệnh INSERT vào bảng prescriptions.

Duyệt Cascade: Nhờ có CascadeType.ALL, Hibernate duyệt qua danh sách details.

Xử lý Transient: Với mỗi PrescriptionDetail trong danh sách:

Nó kiểm tra xem prescription_id đã được gán chưa (thông qua hàm helper addDetail).

Thực hiện lệnh INSERT vào bảng prescription_details.

Kết thúc: Toàn bộ transaction được commit. Cả đơn thuốc và danh sách chi tiết đều nằm an toàn trong Database.