package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("list" , productService.getAllProducts());
        return "listProducts";
    }

    @GetMapping("/searchByName")
    public String searchByName(@RequestParam("proName") String name, Model model) {
        model.addAttribute("list" , productService.findByProductName(name));
        return "listProducts";
    }
}
