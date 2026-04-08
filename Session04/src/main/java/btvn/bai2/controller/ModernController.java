package btvn.bai2.controller;

import btvn.bai2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bai2/orders")
public class ModernController {

    private final OrderService orderService;

    @Autowired
    public ModernController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public String getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public String createOrder() {
        return "Đã tạo đơn hàng mới thành công!";
    }
}
