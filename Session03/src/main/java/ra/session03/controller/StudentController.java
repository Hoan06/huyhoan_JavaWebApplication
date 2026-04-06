package ra.session03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.session03.model.Student;
import ra.session03.service.StudentService;

@Controller
@RequestMapping(value = { "/","students"})
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String listStudents(@RequestParam(name = "sortBy", required = false) String sortBy,
                               @RequestParam(name = "search", required = false) String search,
                               @RequestParam(name = "faculty", required = false) String faculty,
                               Model model) {
        model.addAttribute("students" , studentService.getStudents(sortBy,search,faculty));
        return "listStudents";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam(name = "id") int id, Model model) {
        Student student = studentService.getById(id);
        if (student == null) {
            return "redirect:/students";
        }
        model.addAttribute("student", student);
        return "detail";
    }


    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("total", studentService.totalStudents());
        model.addAttribute("avgGpa", studentService.avgGpa());
        model.addAttribute("topStudent", studentService.topStudent());
        model.addAttribute("statusPercent", studentService.statusPercent());

        return "dashboard";
    }
}
