package session02_btvn.bai4;

public class Answer {
//    1. XSS là gì và tại sao <c:out> an toàn?
//    XSS (Cross-Site Scripting): Là lỗ hổng cho phép kẻ tấn công chèn các đoạn mã kịch bản độc hại (thường là JavaScript) vào trang web. Khi người dùng khác xem trang, trình duyệt của họ sẽ thực thi mã này.
//
//    Tại sao <c:out> an toàn: Mặc định, <c:out> có thuộc tính escapeXml="true". Nó sẽ chuyển đổi các ký tự nhạy cảm của HTML thành các thực thể an toàn (HTML Entities).
//
//    So sánh HTML Output:
//
//    Dùng ${keyword}: Output là <script>alert(1)</script> -> Trình duyệt thực thi mã.
//
//            Dùng <c:out value="${keyword}"/>: Output là &lt;script&gt;alert(1)&lt;/script&gt; -> Trình duyệt hiển thị nguyên văn chuỗi văn bản.
//
//2. Phân biệt <c:if> và <c:choose>
//<c:if>: Dùng cho các logic rẽ nhánh đơn giản (Chỉ có Nếu - Thì). Phù hợp để ẩn/hiện một khối nội dung dựa trên một điều kiện duy nhất.
//
//<c:choose>: Hoạt động giống như switch-case hoặc if-else if-else.
//
//    Áp dụng: Trong bài này, hiển thị "Giá vé" và "Vé còn lại" nên dùng <c:choose>.
//
//    Lý do: Chúng ta có nhiều điều kiện loại trừ lẫn nhau (Ví dụ: Miễn phí OR Có phí; Hết vé OR Sắp hết OR Còn nhiều). Dùng <c:choose> giúp code tường minh và tránh việc kiểm tra thừa các điều kiện sau khi đã tìm thấy nhánh đúng.
//
//            3. Sức mạnh của <c:url>
//    Vấn đề: Hardcode href="/events/1/book" giả định ứng dụng chạy ở root (/). Nếu deploy với context path là /ticketing, link sẽ bị sai (dẫn đến 404).
//
//    Giải pháp: <c:url> tự động chèn context path vào trước URL.
//
//    Deploy tại /ticketing: Link sẽ tự chuyển thành /ticketing/events/1/book. Ngoài ra, nó còn hỗ trợ URL rewriting để duy trì Session nếu trình duyệt người dùng tắt Cookie.
}
