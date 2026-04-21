package ra.service;

import ra.model.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee insertEmployee(Employee employee);
}
