Phần 1: Phân tích về "Starter" trong Spring Boot
Trong mô hình cũ, để làm một ứng dụng Web, bạn phải tự tìm kiếm và khai báo từng thư viện như Spring MVC, Jackson (để xử lý JSON), Tomcat (để chạy server), Logging... Điều này dẫn đến tình trạng "Dependency Hell" (xung đột phiên bản).

Tại sao spring-boot-starter-web được gọi là một "Starter"?
Nó được gọi là Starter vì đóng vai trò như một "bản menu trọn gói". Thay vì gọi từng món lẻ, bạn chỉ cần gọi tên Starter này, Spring Boot sẽ tự động kéo về tất cả các thư viện cần thiết để xây dựng một ứng dụng Web hoàn chỉnh.

Nó giúp lược bỏ việc khai báo các thư viện nhỏ lẻ nào?
Khi khai báo spring-boot-starter-web, bạn không cần khai báo thủ công các thư viện sau:

Spring MVC: Để định nghĩa các Controller và xử lý Request/Response.

Jackson: Để tự động chuyển đổi dữ liệu giữa Java Object và JSON.

Embedded Tomcat: Server được nhúng trực tiếp vào tệp .jar (không cần cài Tomcat bên ngoài).

Spring Core/Beans/Context: Các thành phần nền tảng của Spring Framework.

Validation: Để kiểm tra dữ liệu đầu vào (Hibernate Validator).