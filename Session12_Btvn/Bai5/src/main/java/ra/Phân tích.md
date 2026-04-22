Phân tích kịch bản lỗi (Scenario Analysis)
   Dưới đây là 3 tình huống lỗi phổ biến nếu không cấu hình đúng theo kiến thức Session 12:

Lỗi không tải được tài nguyên tĩnh (404 Not Found cho hình ảnh):
Nếu bạn không đặt ảnh vào đúng thư mục src/main/resources/static/images hoặc dẫn link 
trong HTML không bắt đầu từ /images/..., trình duyệt sẽ không thể tìm thấy ảnh đại diện của bác sĩ.
Trong Spring Boot, mọi thứ trong static được map trực tiếp vào root context.

Xung đột Port và lỗi khởi động:
Nếu máy tính đang chạy một ứng dụng khác trên port 8080 (port mặc định) mà bạn không cấu hình server.port=8081
trong application.properties, ứng dụng sẽ vấp lỗi Port already in use và dừng ngay lập tức.

Lỗi trắng trang (White Label Error Page) do sai Context Path:
Nếu bạn cấu hình server.servlet.context-path=/med-manager nhưng khi truy cập lại gõ trực tiếp 
localhost:8081/, hệ thống sẽ báo lỗi. Bạn bắt buộc phải truy cập qua URL đầy đủ là localhost:8081/med-manager/ 
để vào được hệ thống.