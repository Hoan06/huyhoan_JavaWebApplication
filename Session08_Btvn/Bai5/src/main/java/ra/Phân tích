
1. Thiết kế Kiến trúc & Logic
Danh sách Annotation sử dụng
Mã Tour (tourCode): Sử dụng @Pattern (Standard Annotation) với Regex.

Giá tiền (adultPrice, childPrice): Sử dụng @Min (Standard) và một Custom Class-level Annotation để so sánh hai mức giá.

Lịch trình (startDate, endDate): Sử dụng @FutureOrPresent (Standard) cho ngày bắt đầu và Custom Class-level Annotation để so sánh hai ngày.

Luồng dữ liệu (Data Flow)
User: Nhấn "Submit" trên trình duyệt.

DispatcherServlet: Nhận Request, ánh xạ vào TourController.

Validator Engine: Kiểm tra các Field-level (Regex, Min) trước, sau đó chạy Class-level (So sánh ngày/giá).

BindingResult: Nếu có bất kỳ lỗi nào, thông tin lỗi được nén vào đối tượng này.

Controller: Kiểm tra bindingResult.hasErrors(). Nếu true, trả về View create-tour.

Thymeleaf: Đọc lỗi từ BindingResult và hiển thị chữ đỏ bằng th:errors.

2. Kịch bản Test rủi ro
Mã Tour sai định dạng: Nhập VN_ABCDE.

Chống chịu: @Pattern sẽ chặn lại vì không khớp Regex \d{5}. Hệ thống không crash, trả về thông báo mã không hợp lệ.

Giá trẻ em "phá đáy": Nhập adultPrice = 100k, childPrice = 150k.

Chống chịu: TourValidator thực hiện so sánh chéo, nhận diện giá trẻ em > người lớn và đẩy lỗi vào BindingResult.

Ngày kết thúc xuyên không: Nhập startDate = 2026-05-01, endDate = 2026-04-01.

Chống chịu: Logic !isAfter() trong Validator sẽ phát hiện ngày kết thúc trước ngày bắt đầu và ngăn chặn việc lưu dữ liệu.