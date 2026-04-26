Phần A: Báo cáo phân tích và thiết kế
Phân tích Input/Output (I/O)
   Để tính năng hoạt động linh hoạt, Controller cần tiếp nhận các tham số sau từ URL:

Input (Query Parameters):

page (int): Số trang hiện tại (mặc định là 0).

status (String): Trạng thái đơn hàng (ví dụ: 'DELIVERED', 'CANCELLED' hoặc 'ALL').

sortBy (String): Tên thuộc tính cần sắp xếp (mặc định: createdAt).

direction (String): Hướng sắp xếp (asc hoặc desc).

Output (Model Attributes):

orderPage: Đối tượng Page<Order> chứa danh sách đơn hàng của trang hiện tại và các thông tin meta (tổng trang, tổng phần tử).

currentStatus: Để giữ trạng thái đã chọn trên thanh <select>.

Đề xuất giải pháp kỹ thuật
   Sử dụng bộ công cụ mạnh mẽ của Spring Data JPA:

Pageable: Interface để đóng gói thông tin phân trang (số trang, kích thước trang).

PageRequest.of(page, size, sort): Class cụ thể để tạo đối tượng Pageable.

Page<T>: Kiểu trả về của Repository, chứa dữ liệu đã phân trang và hỗ trợ tính toán tổng số trang tự động.

Sort: Đối tượng dùng để chỉ định tiêu chí sắp xếp.

Thiết kế luồng xử lý (Workflow)
   Trình duyệt: Gửi Request (ví dụ: ?page=-5&sortBy=abc).

Controller: Tiếp nhận các tham số thô.

Service (Lớp xử lý lỗi): * Kiểm tra nếu page < 0 thì gán lại bằng 0.

Dùng try-catch hoặc kiểm tra thuộc tính hợp lệ để xử lý sortBy. Nếu sai, gán lại mặc định là createdAt.

Repository: Thực thi câu lệnh SQL với LIMIT và OFFSET tương ứng.

Controller: Nhận đối tượng Page, gắn vào Model.

View: Duyệt danh sách đơn hàng và hiển thị bộ nút bấm chuyển trang dựa trên orderPage.getTotalPages().