package session04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import session04.service.EmployeeService;

@Controller
@RequestMapping(value = {"/","employees"})
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("employees" , employeeService.getEmployees());
        return "employee/list-employees";
    }

    @GetMapping("/show-employee")
    public String showEmployee(@RequestParam(value = "empId" , required = false) String empId , Model model){
        if (empId == null){
            model.addAttribute("employees" , employeeService.getEmployees());
            return "redirect:/employee/list-employees";
        }
        model.addAttribute("employee" ,  employeeService.findById(empId));
        return "employee/show-employee";
    }
}
