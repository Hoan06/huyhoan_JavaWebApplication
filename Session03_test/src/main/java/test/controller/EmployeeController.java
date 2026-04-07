package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import test.respository.EmployeeRepository;

@Controller
@RequestMapping(value = {"/","employee"})
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public String listEmployee(Model model) {
        model.addAttribute("employees" , employeeRepository.findAll());
        return "employee-list";
    }
}
