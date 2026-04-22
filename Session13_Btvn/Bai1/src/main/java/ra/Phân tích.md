Phần 1: Phân tích nguyên nhân lỗi 
Tại sao thiếu hibernate.dialect lại khiến Hibernate không thể khởi động?
   Hibernate là một framework ORM có khả năng làm việc với rất nhiều hệ quản trị cơ sở dữ liệu khác nhau (MySQL, PostgreSQL, Oracle, SQL Server...). 
Tuy nhiên, mỗi hệ cơ sở dữ liệu lại có "ngôn ngữ" (SQL Dialect) riêng để thực hiện các thao tác cụ thể như phân trang (limit/offset), tạo ID tự tăng, hoặc định dạng kiểu dữ liệu.

Vấn đề: Khi thiếu hibernate.dialect, Hibernate sẽ không biết phải dịch các câu lệnh HQL (Hibernate Query Language) sang ngôn ngữ SQL cụ thể nào của DB bạn đang dùng.

Hệ quả: Nó sẽ báo lỗi "explicitly set" vì không thể đoán được chiến lược tạo câu lệnh SQL tối ưu, dẫn đến dừng quá trình khởi tạo SessionFactory.

Thuộc tính nào giúp Hibernate tự động tạo bảng?
   Để Hibernate tự động quét các Java Class (có đánh dấu @Entity) và sinh ra bảng trong Database, chúng ta sử dụng thuộc tính:

hibernate.hbm2ddl.auto

Các giá trị phổ biến:

update: Tự động cập nhật cấu trúc bảng mà không làm mất dữ liệu cũ (Khuyên dùng khi phát triển).

create: Xóa bảng cũ và tạo lại bảng mới mỗi khi chạy ứng dụng (Mất sạch dữ liệu).

create-drop: Tạo bảng khi khởi động và xóa bảng khi tắt ứng dụng.

validate: Chỉ kiểm tra xem Entity và Table có khớp nhau không, không sửa đổi gì.