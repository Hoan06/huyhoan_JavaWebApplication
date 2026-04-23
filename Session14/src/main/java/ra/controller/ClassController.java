package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.service.ClassService;

@Controller
@RequestMapping("/classes")
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping
    public String showAllClasses(Model model) {
        model.addAttribute("classes" , classService.getAllClasses());
        return "listClasses";
    }
}
