package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.model.entity.Student;
import ra.service.ClassService;
import ra.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassService classService;

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("listClasses" , classService.getAllOnlyClasses());
        return "insertStudent";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("student") Student student ,Model model){
        studentService.addStudent(student);
        model.addAttribute("classes" , classService.getAllClasses());
        return "listClasses";
    }
}
