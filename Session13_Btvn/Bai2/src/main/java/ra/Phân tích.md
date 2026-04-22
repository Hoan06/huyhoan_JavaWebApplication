Phần 1: Phân tích nguyên nhân lỗi 
Tại sao Hibernate bắt buộc phải có @Id?
   Trong kiến trúc ORM (Object-Relational Mapping), mỗi hàng (row) trong bảng cơ sở dữ liệu phải tương ứng với một đối tượng (object) duy nhất trong bộ nhớ Java.

Định danh duy nhất: @Id dùng để đánh dấu trường là Khóa chính (Primary Key). Hibernate sử dụng khóa chính này để quản lý trạng thái của thực thể (Persistent Context), thực hiện các thao tác như update, delete hoặc tìm kiếm (find).

Tính nhất quán: Nếu không có @Id, Hibernate không có cách nào để phân biệt giữa hai bản ghi có dữ liệu giống hệt nhau, dẫn đến việc không thể đảm bảo tính toàn vẹn dữ liệu.

Cách cấu hình tên bảng khác với tên Class Java?
   Mặc định, Hibernate sẽ lấy tên Class (ví dụ: Medicine) làm tên bảng. Để thay đổi điều này, chúng ta sử dụng Annotation @Table.

Cấu trúc: @Table(name = "tên_bảng_mong_muốn")

Ngoài ra, bạn cũng có thể dùng @Column(name = "tên_cột") để đổi tên các trường dữ liệu nếu quy định của DB yêu cầu (ví dụ: medicine_name thay vì name).