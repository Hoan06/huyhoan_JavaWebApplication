package session02_btvn.bai3;

public class Analysis {
//    1. Request Scope vs Session Scope cho thông báo lỗi
//    Tại sao dùng Request Scope: Thông báo lỗi đăng nhập (ví dụ: "Sai mật khẩu") chỉ có giá trị ngay tại thời điểm đó. Khi người dùng nhận được phản hồi và trang login tải lại, thông báo hiển thị xong là hết nhiệm vụ.
//
//    Nếu dùng Session Scope: Thông báo lỗi sẽ "dính" chặt vào phiên làm việc của người dùng. Nếu họ F5 (tải lại trang) hoặc quay lại trang login sau đó, thông báo lỗi cũ vẫn còn hiển thị dù họ chưa bấm đăng nhập lại, gây hiểu lầm và trải nghiệm người dùng tệ.
//
//            2. Tại sao totalViewCount phải lưu vào Application Scope?
//    Lý do: Application Scope (ServletContext) là vùng nhớ dùng chung cho toàn bộ ứng dụng và tất cả người dùng.
//
//    Nếu lưu vào Session Scope: Mỗi nhân viên sẽ có một bộ đếm riêng. Nhân viên A xem 5 lần thì máy A hiện số 5, nhân viên B xem 10 lần thì máy B hiện số 10. Hệ thống sẽ không bao giờ biết được tổng số lượt xem của toàn bộ cửa hàng.
//
//3. Race Condition và cách phòng tránh
//    Race Condition là gì: Là tình huống xảy ra khi nhiều luồng (nhiều nhân viên) cùng truy cập và sửa đổi một dữ liệu dùng chung (totalViewCount) tại cùng một thời điểm.
//
//    Tại sao đoạn code trên nguy hiểm: 1. Luồng 1 đọc count = 10.
//2. Luồng 2 đọc count = 10 (ngay trước khi luồng 1 kịp tăng).
//            3. Luồng 1 tăng lên 11 và set lại.
//4. Luồng 2 cũng tăng lên 11 và set lại.
//
//    Kết quả: Lẽ ra phải là 12, nhưng chỉ còn 11. Một lượt xem đã bị "bốc hơi".
//
//    Giải pháp: Sử dụng synchronized block hoặc tốt nhất là dùng AtomicInteger để đảm bảo tính nguyên tử (atomic) khi tăng giá trị.
}
