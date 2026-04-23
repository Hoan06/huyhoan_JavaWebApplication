Phần 1: Phân tích & Đề xuất giải pháp
1. Phân tích I/O
   Input: orderId, productId, quantity, expiryTime (15 phút kể từ lúc Checkout).

Kết quả mong đợi:

Sản phẩm được trừ tạm thời (Reserved) để người khác không mua mất.

Nếu thanh toán thành công: Chuyển trạng thái đơn sang COMPLETED.

Nếu quá 15 phút: Trạng thái đơn chuyển sang EXPIRED, số lượng hàng tự động cộng lại vào kho.

2. Đề xuất 2 giải pháp
   Giải pháp 1: Trạng thái đơn hàng (Soft Reservation)

Khi khách nhấn Checkout, hệ thống trừ kho ngay lập tức và tạo đơn hàng ở trạng thái PENDING_PAYMENT.

Bản ghi đơn hàng có thêm cột expire_at.

Ưu điểm: Transaction kết thúc cực nhanh, không treo DB.

Giải pháp 2: Scheduled Task (Quét định kỳ)

Sử dụng @Scheduled (trong Spring) hoặc một Worker để quét Database mỗi 1 phút một lần.

Tìm các đơn hàng PENDING_PAYMENT có expire_at < hiện tại.

Thực hiện hoàn kho cho các đơn hàng này trong một Transaction riêng biệt.

Phần 2: So sánh và Lựa chọn
Dưới đây là so sánh giữa hai giải pháp:

Về Tốc độ xử lý:

Giải pháp 1 nhanh hơn cho người dùng lúc thanh toán vì Transaction ngắn.

Giải pháp 2 tốn tài nguyên hệ thống hơn một chút do phải chạy quét định kỳ nhưng không ảnh hưởng trực tiếp đến trải nghiệm người dùng lúc mua.

Về Độ an toàn dữ liệu:

Giải pháp 1 có nguy cơ "quên" hoàn kho nếu không có cơ chế trigger.

Giải pháp 2 an toàn tuyệt đối vì nó là "người dọn dẹp" tự động, đảm bảo mọi đơn hàng hết hạn đều được xử lý.

Về Tài nguyên bộ nhớ:

Cả hai giải pháp đều tiết kiệm bộ nhớ hơn việc giữ Long-running Transaction.

Giải pháp 2 tốn một ít tài nguyên CPU để chạy tác vụ ngầm.

Về Độ phức tạp khi bảo trì:

Giải pháp 1 đơn giản, dễ code.

Giải pháp 2 yêu cầu cấu hình thêm các thư viện lập lịch (như Spring Schedule hoặc Quartz) và phải xử lý trường hợp nhiều Instance cùng quét một lúc (Distributed Lock).

=> Chốt lựa chọn: Sử dụng kết hợp Trạng thái đơn hàng + Scheduled Task. Đây là giải pháp tiêu chuẩn của các sàn TMĐT lớn (Shopee, Lazada) vì nó giải phóng tài nguyên DB ngay lập tức và đảm bảo kho luôn chính xác.