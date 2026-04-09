package session05.bai5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import session05.bai2.common.Dish;
import session05.bai5.service.OrderService;

import java.util.List;

@Controller
public class DishDetailController {

    @Autowired
    private OrderService service;

    @GetMapping("/bai5/order")
    public String orderPage(Model model) {
        List<Dish> dishes = service.getMenu();
        model.addAttribute("dishes", dishes);
        model.addAttribute("total", service.calculateTotal(dishes));
        return "order";
    }

    @GetMapping("/bai5/detail/{id}")
    public String detail(@PathVariable("id") int id,
                         Model model,
                         RedirectAttributes redirectAttributes) {

        Dish dish = service.getDishById(id);

        if (dish == null) {
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy món ăn!");
            return "redirect:/bai2/dishes";
        }

        model.addAttribute("dish", dish);
        return "dish-detail";
    }
}