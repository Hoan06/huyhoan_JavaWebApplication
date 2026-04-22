Phần 1: Phân tích kịch bản lỗi LazyInitializationException
Tại sao lỗi xảy ra? Khi bạn cấu hình danh sách thuốc trong đơn thuốc là FetchType.LAZY, Hibernate sẽ không tải dữ liệu này ngay lập tức. Nếu bạn đóng Session trong Repository, sau đó ra ngoài tầng View (Thymeleaf) mới gọi prescription.getDetails(), Hibernate sẽ cố gắng kết nối lại DB để lấy dữ liệu. Vì Session đã đóng, nó không thể thực hiện truy vấn và tung ra lỗi này.

Cách khắc phục:

Cách 1 (Join Fetch): Sử dụng HQL với từ khóa JOIN FETCH để lấy luôn danh sách chi tiết thuốc ngay trong Session còn mở. (Khuyên dùng).

Cách 2 (OpenSessionInView): Cấu hình Filter để giữ Session mở cho đến khi View render xong (Tuy nhiên cách này đôi khi gây áp lực lên kết nối DB).

Cách 3 (Initialize): Gọi Hibernate.initialize(prescription.getDetails()) trước khi đóng Session.