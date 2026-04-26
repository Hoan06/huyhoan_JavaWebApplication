Phần 1: Báo cáo Phân tích & Thiết kế
I. Xác định Luồng Dữ liệu (Input/Output)
Tính năng 1 (Lọc Marketing):

Input: Nhận chuỗi category đại diện cho tên danh mục.

Output: Một danh sách thực thể Product đã được lọc cứng điều kiện status = true ngay từ tầng truy vấn.

Tính năng 2 (Trang danh sách Bán chạy):

Input: Các tham số điều hướng bao gồm page (vị trí trang) và size (số lượng sản phẩm mỗi trang).

Output: Đối tượng Page<Product> chứa dữ liệu sản phẩm kèm theo siêu dữ liệu (metadata) như tổng số trang, tổng số phần tử để hỗ trợ hiển thị giao diện phân trang.

Tính năng 3 (API tối ưu Mobile):

Input: Mã định danh duy nhất id của sản phẩm.

Output: Một Proxy Object thuộc kiểu ProductSlimDTO chỉ chứa hai thuộc tính: tên và giá, giúp giảm kích thước gói tin JSON.

Tính năng 4 (Bộ lọc thông minh):

Input: Tập hợp các tham số tùy chọn (Optional) gồm name, minPrice, và maxPrice.

Output: Danh sách sản phẩm thỏa mãn đồng thời các điều kiện hiện có (Dynamic Predicates).

II. Phân tích Kỹ thuật: Method Query so với @Query
Trong bài toán số 2, việc lựa chọn công cụ truy vấn ảnh hưởng trực tiếp đến khả năng bảo trì và hiệu suất:

Đối với Method Query (Derived Query):
   Cách tiếp cận này dựa trên quy tắc đặt tên hàm để Spring tự sinh SQL.

Ưu điểm: Cực kỳ nhanh gọn cho các truy vấn đơn giản, giúp giảm bớt mã nguồn thừa.

Nhược điểm: Khi yêu cầu bao gồm cả lọc trạng thái, phân trang và sắp xếp, tên hàm sẽ trở nên quá dài (ví dụ: findByStatusTrueOrderByPriceDesc), gây khó đọc và khó mở rộng nếu sau này cần thêm các điều kiện logic phức tạp hơn.

Đối với Custom Query (@Query):
   Sử dụng ngôn ngữ JPQL để định nghĩa câu lệnh truy vấn.

Ưu điểm: Tách biệt rõ ràng giữa logic lọc dữ liệu và tham số phân trang. Giúp nhà phát triển kiểm soát hoàn toàn cấu trúc câu lệnh SQL được sinh ra, tối ưu hóa việc lấy dữ liệu (Fetch) và dễ dàng xử lý các câu lệnh phức tạp mà Method Query không hỗ trợ tốt.

Nhược điểm: Đòi hỏi người viết phải nắm vững cú pháp JPQL và có nguy cơ lỗi cú pháp cao hơn nếu không được kiểm tra kỹ.

=> Kết luận: Đối với tính năng "Bán chạy", sử dụng @Query kết hợp với tham số Pageable là giải pháp tối ưu nhất vì nó giữ cho code sạch sẽ và có hiệu suất cao khi xử lý lượng dữ liệu lớn.

III. Mô tả Quy trình Chặn Bẫy Dữ liệu (Data Guard)
Để hệ thống Rikkei Store vận hành ổn định, lớp Service đóng vai trò là "người gác cổng" thông qua hai quy tắc kiểm soát chính:

Kiểm soát Biên (Boundary Control): Khi nhận tham số page từ Client, hệ thống thực hiện phép so sánh Math.max(page, 0). Điều này đảm bảo rằng ngay cả khi người dùng cố tình thay đổi URL thành số âm, hệ thống vẫn trả về dữ liệu của trang đầu tiên thay vì văng lỗi IllegalArgumentException.

Kiểm soát Logic Nghiệp vụ (Logical Validation): Đối với bộ lọc khoảng giá, hệ thống thực hiện kiểm tra chéo giữa minPrice và maxPrice. Nếu xảy ra tình trạng "giá bắt đầu > giá kết thúc", hệ thống chủ động ném ra một BusinessException kèm thông báo rõ ràng. Điều này ngăn chặn việc thực thi các câu lệnh SQL vô nghĩa (luôn trả về rỗng) và giúp khách hàng nhận diện được thao tác sai của mình.