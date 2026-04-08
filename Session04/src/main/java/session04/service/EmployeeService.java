package session04.service;

import session04.model.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee findById(String id);
}
