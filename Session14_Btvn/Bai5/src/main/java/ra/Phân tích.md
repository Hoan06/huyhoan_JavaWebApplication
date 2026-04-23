Phần 1: Thiết kế kiến trúc (Architecture Design)
Xác định các Entity & Mối quan hệ
   Hệ thống cần các thực thể cốt lõi sau:

Wallet (Ví): Quản lý số dư của khách hàng (balance).

Vendor (Nhà cung cấp): Mỗi sản phẩm phải thuộc về một Vendor. Vendor có tài khoản để nhận tiền.

Product (Sản phẩm): Gắn với vendorId và stock.

Order (Đơn hàng tổng): Chứa thông tin tổng tiền và trạng thái.

OrderDetail (Chi tiết đơn hàng): Lưu từng item, số lượng và giá tại thời điểm mua.

Mối quan hệ:

Order --(1:N)--> OrderDetail

Vendor --(1:N)--> Product

OrderDetail --(N:1)--> Product

Quản lý Transaction (Propagation)
   Để đảm bảo tính nguyên tử, chúng ta sử dụng cơ chế Propagation.REQUIRED:

Tầng Service Tổng (CheckoutService): Khởi tạo một Transaction lớn.

Tầng Sub-Service (VendorService): Khi trừ kho và cộng tiền cho từng Vendor, các hành động này sẽ tham gia (Join) vào Transaction lớn đang có. Nếu bất kỳ Vendor nào lỗi, toàn bộ "Transaction tổng" sẽ Rollback.

Phần 2: Phân tích rủi ro (Edge Cases)
Hệ thống cần được thiết kế để "sống sót" qua 3 kịch bản sau:

Tranh chấp kho (Concurrency): Hai khách hàng cùng mua sản phẩm cuối cùng của Vendor B.

Giải pháp: Sử dụng Pessimistic Lock khi kiểm tra kho sản phẩm.

Lỗi logic nghiệp vụ giữa chừng: Đã thanh toán xong cho Vendor A, nhưng đến Vendor B thì phát hiện sản phẩm đã bị xóa hoặc ngừng kinh doanh.

Giải pháp: Transaction Rollback sẽ hoàn trả tiền lại ví khách hàng và cộng lại kho cho Vendor A.

Nhập liệu sai (Human Error): Người dùng nhập số lượng là một chuỗi văn bản hoặc số âm trong Console.

Giải pháp: Sử dụng Scanner.hasNextInt() và khối try-catch trong vòng lặp Menu để bắt lỗi định dạng.