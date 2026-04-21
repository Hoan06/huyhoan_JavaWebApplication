package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.model.entity.Employee;
import ra.service.EmployeeService;

@Controller
@RequestMapping({"/","/employees"})
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String home(Model model){
        model.addAttribute("employees", employeeService.getEmployees());
        return "list-employees";
    }

    @GetMapping("/add-employee")
    public String addEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "insert-employee";
    }

    @PostMapping("/add-employee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.insertEmployee(employee);
        return "redirect:/employees";
    }

}
