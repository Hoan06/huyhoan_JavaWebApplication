package btvn.bai4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderDetailController {

//    Lựa chọn của em:
//    em chọn Cách A.
//
//    Lý do: Theo tiêu chuẩn thiết kế RESTful, khi muốn chỉ định một đối tượng cụ thể và duy nhất (như một đơn hàng, một khách hàng), chúng ta nên dùng Path Variable.
//    Nó giúp URL trông sạch sẽ, dễ hiểu và thể hiện rõ cấu trúc phân cấp tài nguyên.
//
//    Cách A thường dùng để: Xác định danh tính
//
//    Cách B thường dùng để: Tìm kiếm, lọc, hoặc phân trang


    @GetMapping("/bai4/orders/{id}")
    public String getOrderDetail(@PathVariable("id") Long orderId) {

        return "Chi tiết đơn hàng số " + orderId;
    }
}