package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.model.Dish;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/merchant/dish")
public class DishController {

    @ModelAttribute("categories")
    public List<String> getCategories() {
        System.out.println("Tự động nạp danh sách nhóm món ăn..."); // Kiểm chứng cơ chế chạy
        return Arrays.asList("Món chính", "Đồ uống", "Tráng miệng", "Topping");
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("dish", new Dish());
        return "dish-add";
    }

    @GetMapping("/edit")
    public String showEditForm(Model model) {
        model.addAttribute("dish", new Dish("Trà sữa", "Đồ uống"));
        return "dish-edit";
    }

    @GetMapping("/search")
    public String showSearchPage() {
        return "dish-search";
    }
}