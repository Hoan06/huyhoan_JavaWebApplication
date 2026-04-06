package session02_btvn.bai3;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@Controller
public class OrderController {

    @GetMapping("/orders")
    public String showOrders(HttpSession session, Model model, HttpServletRequest request) {
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        List<Order> orders = Arrays.asList(
                new Order("ORD001", "Laptop Dell XPS", 25000000, new Date()),
                new Order("ORD002", "Chuột Logitech G502", 1200000, new Date()),
                new Order("ORD003", "Bàn phím cơ Akko", 1850000, new Date())
        );
        model.addAttribute("orderList", orders);

        ServletContext application = request.getServletContext();
        synchronized (application) {
            Integer count = (Integer) application.getAttribute("totalViewCount");
            if (count == null) count = 0;
            application.setAttribute("totalViewCount", count + 1);
        }

        return "orders";
    }
}