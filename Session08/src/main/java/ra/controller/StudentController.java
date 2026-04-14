package ra.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.model.dto.Student;

@Controller
@RequestMapping("/students")
public class StudentController {
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("student", new Student());
        return "insertStudent";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("student") Student student , BindingResult result , Model model) {
        if (result.hasErrors()) {
            model.addAttribute("student", student);
            return "insertStudent";
        }
        model.addAttribute("student", student);
        return "viewStudent";
    }
}
