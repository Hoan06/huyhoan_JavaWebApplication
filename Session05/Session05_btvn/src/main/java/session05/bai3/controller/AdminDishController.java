package session05.bai3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import session05.bai2.common.Dish;
import session05.bai3.service.AdminDishService;

@Controller
public class AdminDishController {

    @Autowired
    private AdminDishService service;

    @GetMapping("/bai3/edit/{id}")
    public String editDish(@PathVariable("id") int id, Model model) {

        Dish dish = service.findById(id);

        if (dish == null) {
            model.addAttribute("error", "Không tìm thấy món ăn yêu cầu!");
            return "redirect:/bai2/dishes";
        }

        model.addAttribute("dish", dish);
        return "edit-dish";
    }
}