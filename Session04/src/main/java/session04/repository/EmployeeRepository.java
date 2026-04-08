package session04.repository;

import session04.model.entity.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();
    Employee findById(String id);
}
