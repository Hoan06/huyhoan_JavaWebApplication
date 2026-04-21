Phần 1: Phân tích về Quản lý Cấu hình trong Spring Boot
Spring Boot quản lý các cấu hình mặc định như thế nào?
Spring Boot hoạt động theo triết lý "Convention over Configuration" (Quy ước thay vì cấu hình).

Khi bạn thêm một Starter (như spring-boot-starter-web), Spring Boot sẽ tự động nạp các giá trị mặc định từ các file cấu hình nằm bên trong các tệp .jar của thư viện (thường là additional-spring-configuration-metadata.json).

Cơ chế Externalized Configuration cho phép chúng ta "ghi đè" (override) các giá trị mặc định này bằng cách sử dụng file application.properties, biến môi trường, hoặc tham số dòng lệnh mà không cần sửa code Java.

Tìm danh sách cấu hình mặc định ở đâu?
Bạn có thể tra cứu toàn bộ danh sách các thuộc tính (Common Application Properties) tại:

Trang chủ Spring: Tài liệu chính thức Spring Boot Reference Guide.

Trong IDE: Khi bạn gõ trong file application.properties, các IDE hiện đại như IntelliJ IDEA hay VS Code sẽ tự động gợi ý (Auto-complete) kèm theo mô tả chi tiết của từng thuộc tính.