package session02_btvn.bai5;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        employees.add(new Employee("NV001", "Nguyễn Thị Lan", "Kế toán", 15000000, "2020-03-01", "Đang làm"));
        employees.add(new Employee("NV002", "Trần Văn Hùng", "Kỹ thuật", 25000000, "2019-07-15", "Đang làm"));
        employees.add(new Employee("NV003", "Lê Minh Đức", "Kinh doanh", 18500000, "2021-11-20", "Nghỉ phép"));
    }

    public List<Employee> getAll() { return employees; }

    public Employee getByCode(String code) {
        return employees.stream()
                .filter(e -> e.getCode().equalsIgnoreCase(code))
                .findFirst().orElse(null);
    }

    public double calculateTotalSalaryByDept(String dept) {
        return employees.stream()
                .filter(e -> e.getDepartment().equals(dept))
                .mapToDouble(Employee::getSalary).sum();
    }
}