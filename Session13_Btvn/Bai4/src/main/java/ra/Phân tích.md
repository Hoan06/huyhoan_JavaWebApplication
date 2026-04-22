Phân tích: HQL và Native SQL Query
   Đối tượng tác động: * Native SQL: Làm việc trực tiếp với các thực thể vật lý trong Database như tên bảng (TABLE_NAME) và tên cột (COLUMN_NAME).

HQL: Làm việc với các thực thể logic trong Java như tên Class (Entity) và tên thuộc tính (Field).

Tính linh hoạt khi thay đổi Database:

Native SQL: Nếu bạn chuyển từ MySQL sang Oracle hoặc SQL Server, bạn có thể phải viết lại truy vấn vì cú pháp của mỗi hệ quản trị khác nhau (ví dụ: cách phân trang LIMIT vs TOP).

HQL: Bạn chỉ cần viết một lần. Hibernate sẽ tự động dịch sang SQL chuẩn của Database bạn đang cấu hình thông qua Dialect.

An toàn khi bảo trì mã nguồn:

Native SQL: Nếu bạn đổi tên cột trong DB, bạn phải tìm tất cả các chuỗi SQL trong code Java để sửa lại, rất dễ sót và gây lỗi runtime.

HQL: Nếu bạn đổi tên cột trong DB, bạn chỉ cần sửa duy nhất tại Annotation @Column trong Entity. Câu lệnh HQL vẫn giữ nguyên vì nó chỉ quan tâm đến tên biến trong Java.

Kiểu dữ liệu trả về:

Native SQL: Thường trả về một mảng đối tượng (Object[]), bạn phải tốn công ép kiểu thủ công từng phần tử.

HQL: Trả về trực tiếp danh sách đối tượng có kiểu (ví dụ: List<Medicine>), giúp code an toàn và dễ đọc hơn.