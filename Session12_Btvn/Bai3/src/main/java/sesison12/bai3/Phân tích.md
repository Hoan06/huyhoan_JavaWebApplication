Phần 1: Phân tích lợi ích của application.properties
Thay vì viết trực tiếp các chuỗi ký tự vào code Java, việc đưa chúng vào file cấu hình mang lại 3 lợi ích cốt lõi:

Dễ dàng bảo trì (Centralized Management): Bạn chỉ cần thay đổi giá trị tại một nơi duy nhất. Thay vì tìm và sửa Hotline ở 10 Controller khác nhau, bạn chỉ sửa 1 dòng trong file cấu hình.

Tách biệt môi trường (Environment Separation): Bạn có thể dễ dàng thay đổi địa chỉ Database Server khi chạy trên máy cá nhân (Local), máy kiểm thử (Staging) hoặc máy chủ thực tế (Production) mà không cần biên dịch lại mã nguồn.

Tính bảo mật: Các thông tin nhạy cảm (mật khẩu database, API Key) sẽ không bị lộ trực tiếp trong code khi bạn chia sẻ dự án hoặc đẩy lên các hệ thống quản lý phiên bản như GitHub.