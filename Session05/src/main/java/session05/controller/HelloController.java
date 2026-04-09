package session05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import session05.model.entity.Product;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"/" , "/hello"})
public class HelloController {
    @GetMapping
    public String hello(Model model) {
        model.addAttribute("message", "Hoàn");

        List<String> list = new ArrayList<>();
        list.add("Hello World");
        list.add("Dũng oc");
        list.add("36hoathanh");
        model.addAttribute("list", list);
        return "home";
    }

    @GetMapping("product-lists")
    public String productLists(Model model) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Laptop Dell XPS 13", "Dell", 2022, Date.valueOf("2027-12-31"), 25000000.0));
        productList.add(new Product(2, "iPhone 14 Pro", "Apple", 2023, Date.valueOf("2026-09-20"), 30000000.0));
        productList.add(new Product(3, "Samsung Galaxy S23", "Samsung", 2023, Date.valueOf("2026-08-15"), 22000000.0));
        productList.add(new Product(4, "Tai nghe Sony WH-1000XM5", "Sony", 2022, Date.valueOf("2028-01-01"), 8000000.0));
        productList.add(new Product(5, "Chuột Logitech MX Master 3S", "Logitech", 2021, Date.valueOf("2027-05-10"), 2500000.0));
        model.addAttribute("productList", productList);
        return "product-lists";
    }
}
