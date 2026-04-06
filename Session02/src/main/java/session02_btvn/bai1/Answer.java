//1. Lỗi trong MyWebAppInitializer.java (/api/*):
//
//Giải thích: Cấu hình "/api/*" có nghĩa là DispatcherServlet chỉ tiếp nhận và xử lý các Request bắt đầu bằng tiền tố /api (ví dụ: /api/welcome, /api/user). Khi bạn truy cập URL /welcome, Tomcat không tìm thấy Servlet nào khớp với URL này nên trả về lỗi 404 Not Found.
//
//DispatcherServlet đang nghe: Chỉ nghe các URL có định dạng http://localhost:8080/demo/api/...
//
//2. Lỗi trong WebConfig.java (@ComponentScan):
//
//Hậu quả: Spring Container chỉ thực hiện quét và khởi tạo các Bean (Component, Service,...) nằm trong package com.demo.service.
//
//Vấn đề: Các lớp được đánh dấu @Controller thường nằm ở package com.demo.controller. Với cấu hình này, Spring MVC sẽ không tìm thấy WelcomeController. Do đó, dù bạn có sửa URL mapping đúng đi nữa, Spring cũng không biết điều hướng Request đến đâu, dẫn đến lỗi không tìm thấy Handler.
//
//3. Tổng hợp:
//
//Câu trả lời: Ứng dụng KHÔNG chạy được.
//
//Tại sao: Nếu chỉ sửa lỗi 1, DispatcherServlet đã nhận được Request /welcome, nhưng khi nó hỏi HandlerMapping xem "Controller nào xử lý URL này?", Spring sẽ báo là không có Controller nào cả (vì lỗi 2 khiến Controller không được quét vào Context). Kết quả thường vẫn là lỗi 404 từ phía Spring hoặc lỗi cấu hình hệ thống.