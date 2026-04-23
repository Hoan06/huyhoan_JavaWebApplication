Phần 1: Phân tích rủi ro hệ thống
Tại sao đơn hàng vẫn bị đổi trạng thái khi "Hoàn kho" lỗi?
   Khi chạy ở chế độ auto-commit (mặc định của Hibernate/JDBC nếu không mở Transaction), mỗi lệnh session.update() sẽ tương đương với một phiên làm việc độc lập với Database:

Bước 1 (Hủy đơn): Lệnh session.update(order) thực hiện thành công và ghi ngay vào Database. Trạng thái đơn hàng lúc này đã là "CANCELLED".

Bước 2 (Hoàn kho): Giả sử order.getProductId() bị null. Một ngoại lệ (Exception) sẽ bị ném ra. Chương trình dừng lại và nhảy vào khối catch.

Kết quả: Bước 1 đã lưu, bước 2 chưa chạy. Hệ thống không có cơ chế tự động "thu hồi" lại lệnh ở bước 1 vì chúng không nằm chung trong một khối quản lý thống nhất.

Thiệt hại cho kho hàng
   Điều này dẫn đến kịch bản "Thất thoát hàng hóa ảo":

Trên hệ thống, đơn hàng đã hủy (khách không lấy hàng).

Tuy nhiên, số lượng sản phẩm thực tế trong kho không được cộng lại.

Hậu quả: Kho bị thiếu hụt số lượng so với thực tế. Bạn có hàng để bán nhưng hệ thống báo hết hàng (Out of stock), dẫn đến mất doanh thu và sai lệch báo cáo kiểm kê.