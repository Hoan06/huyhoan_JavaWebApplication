package session05.bai2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import session05.bai2.service.DishService;

@Controller
public class DishController {
    private DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/bai2")
    public String bai2(Model model) {
        if (dishService.getAllDishes().isEmpty()) {
            model.addAttribute("check" , "Hiện tại nhà hàng đang cập nhật thực đơn, vui lòng quay lại sau");
            return "dish-list";
        }
        model.addAttribute("list", dishService.getAllDishes());
        return "dish-list";
    }
}
