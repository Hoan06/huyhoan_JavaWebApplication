package btvn.bai5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @GetMapping("/bai5/products")
    public String showProducts(
            @RequestParam(name = "category", defaultValue = "all") String category,
            @RequestParam(name = "limit", defaultValue = "5") Integer limit,
            ModelMap model
    ) {
        model.addAttribute("cateName", category).addAttribute("pageSize", limit).addAttribute("msg", "Tìm kiếm thành công!");

        return "btvn/productList";
    }
}