Phần 1: Phân tích về Quản lý Phiên bản (Version Management)
Tại sao không cần ghi rõ số phiên bản (version)?
Trong Spring Boot, khả năng này được cung cấp bởi cơ chế BOM (Bill of Materials) thông qua plugin io.spring.dependency-management.

Tính đồng nhất: Spring Boot chỉ định một "danh mục" các phiên bản thư viện đã được kiểm thử kỹ lưỡng để đảm bảo chúng hoạt động tương thích 100% với nhau.

Tránh xung đột: Nếu bạn tự khai báo phiên bản lẻ tẻ, rất dễ dẫn đến lỗi NoSuchMethodError do các thư viện không khớp phiên bản. Khi nâng cấp phiên bản Spring Boot Parent,
tất cả các thư viện con sẽ tự động được nâng cấp theo một cách an toàn.