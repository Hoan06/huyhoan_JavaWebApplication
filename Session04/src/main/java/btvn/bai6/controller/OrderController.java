package btvn.bai6.controller;

import btvn.bai6.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestController
@RequestMapping("/bai6/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public String getOrder(@PathVariable Long id) {
        return orderService.getOrderDetails(id);
    }

    @PostMapping
    public String createOrder() {
        return orderService.createOrder();
    }

    @DeleteMapping("/{id}")
    public String cancelOrder(@PathVariable Long id) {
        return orderService.cancelOrder(id);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleTypeMismatch() {
        return "Lỗi: ID đơn hàng phải là một số (nguyên dương). Vui lòng không nhập chữ cái!";
    }
}
