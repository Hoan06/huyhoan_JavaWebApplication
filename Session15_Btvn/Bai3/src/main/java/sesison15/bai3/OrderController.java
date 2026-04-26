package sesison15.bai3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/history")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public String showHistory(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "ALL") String status,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "desc") String direction,
            Model model) {

        Long userId = 1L;

        Page<Order> orderPage = orderService.getOrders(userId, status, page, sortBy, direction);

        model.addAttribute("orders", orderPage.getContent());
        model.addAttribute("currentPage", orderPage.getNumber());
        model.addAttribute("totalPages", orderPage.getTotalPages());
        model.addAttribute("status", status);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("direction", direction);

        return "order_history_view";
    }
}
