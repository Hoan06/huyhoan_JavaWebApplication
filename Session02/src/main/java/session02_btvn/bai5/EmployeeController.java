package session02_btvn.bai5;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String listEmployees(HttpSession session, Model model) {
        if (session.getAttribute("loggedUser") == null) return "redirect:/login";

        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("techTotalSalary", employeeService.calculateTotalSalaryByDept("Kỹ thuật"));
        return "employee-list";
    }

    @GetMapping("/{code}")
    public String detail(@PathVariable String code, HttpSession session, Model model) {
        if (session.getAttribute("loggedUser") == null) return "redirect:/login";

        Employee emp = employeeService.getByCode(code);
        if (emp == null) throw new RuntimeException("Nhân viên [" + code + "] không tồn tại");

        model.addAttribute("employee", emp);
        return "employee-detail";
    }
}