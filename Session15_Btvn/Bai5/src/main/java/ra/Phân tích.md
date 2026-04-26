Chiến lược xử lý Concurrency (Tranh chấp dữ liệu)
   Tại sao lỗi "vượt quá số lượng" xảy ra?
   Lỗi này xảy ra do tiến trình Read-Modify-Write:

Luồng A đọc số lượng còn lại (còn 1).

Luồng B cũng đọc số lượng còn lại (vẫn thấy còn 1 vì Luồng A chưa kịp cập nhật).

Cả A và B cùng thực hiện trừ số lượng và ghi đè lại vào DB. Kết quả: 2 mã được phát ra trong khi thực tế chỉ còn 1.

Đề xuất giải pháp: Pessimistic Locking (Khóa bi quan)
Trong bối cảnh Flash Sale (số lượng rất ít, người tranh giành cực đông), Pessimistic Locking (@Lock(LockModeType.PESSIMISTIC_WRITE)) là lựa chọn tối ưu nhất.

Lý do: Khóa bi quan sẽ khóa dòng dữ liệu đó ngay từ khi đọc (SELECT ... FOR UPDATE). Nếu Luồng A đang xử lý, Luồng B phải xếp hàng đợi. Điều này ngăn chặn hoàn toàn việc đọc dữ liệu sai lệch ngay từ đầu.

So sánh với Optimistic Locking: Khóa lạc quan dùng @Version sẽ gây ra rất nhiều lỗi ObjectOptimisticLockingFailureException khi hàng nghìn người cùng tác động, dẫn đến trải nghiệm người dùng tệ vì phải bấm lại nhiều lần.