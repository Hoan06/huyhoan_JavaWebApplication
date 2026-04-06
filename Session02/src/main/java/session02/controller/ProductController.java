package session02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import session02.model.Product;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"/", "/products"})
public class ProductController {
    @GetMapping
    public String home(Model model) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<Product> products = new ArrayList<>();
        products.add(new Product("P02", "Điện thoại", "Samsung", 2024, LocalDate.parse("15/10/2026", dtf), 12000000.0));
        products.add(new Product("P03", "Laptop", "Asus", 2023, LocalDate.parse("01/08/2027", dtf), 18000000.0));
        products.add(new Product("P04", "Tai nghe", "Sony", 2025, LocalDate.parse("05/05/2028", dtf), 2500000.0));
        products.add(new Product("P05", "Chuột", "Logitech", 2022, LocalDate.parse("20/03/2026", dtf), 500000.0));
        products.add(new Product("P06", "Bàn phím", "Razer", 2024, LocalDate.parse("11/11/2027", dtf), 1500000.0));

        model.addAttribute("products", products);
        return "listProducts";
    }
}
