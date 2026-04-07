package test.respository;

import org.springframework.stereotype.Repository;
import test.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    List<Employee> employees = new ArrayList<>();

    public EmployeeRepository() {
        employees.add(new Employee(1, "Nguyễn Huy Hoàn", "CNTT", 50000.00));
        employees.add(new Employee(2, "An Hải Dũng", "MARKETING", 10000.00));
        employees.add(new Employee(3, "Phạm Tiến Hưng", "CNTT", 5000.00));
        employees.add(new Employee(4, "Hà Minh Trang", "CNTT", 36000.00));
        employees.add(new Employee(5, "Đào Trường Sơn", "MARKETING", 20000.00));
    }

    public List<Employee> findAll() {
        return employees;
    }
}
