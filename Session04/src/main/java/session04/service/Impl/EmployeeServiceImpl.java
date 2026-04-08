package session04.service.Impl;

import org.springframework.stereotype.Service;
import session04.model.entity.Employee;
import session04.repository.EmployeeRepository;
import session04.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(String id) {
        return employeeRepository.findById(id);
    }
}
