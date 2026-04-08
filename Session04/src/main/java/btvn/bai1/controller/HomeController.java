package btvn.bai1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bai1")
public class HomeController {

    @GetMapping
    public String home(Model model) {
        model.addAttribute("message", "Chào mừng đến với Restaurant Management!");
        return "btvn/home";
    }
}
