package session04.repository.Impl;

import org.springframework.stereotype.Repository;
import session04.model.entity.Employee;
import session04.repository.EmployeeRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private List<Employee> employees;

    public EmployeeRepositoryImpl() {
        employees = new ArrayList<>();
        employees.add(new Employee("E001", "Nguyễn Huy Hoàn", true, Date.valueOf("2000-05-12"), "Hà Nội", "IT", "Developer", 1200.0));
        employees.add(new Employee("E002", "Hà Minh Trang", false, Date.valueOf("1999-08-23"), "Thanh Hóa", "HR", "HR Manager", 1500.0));
        employees.add(new Employee("E003", "An Hải Dũng", true, Date.valueOf("2001-01-15"), "Hưng Yên", "Finance", "Accountant", 1300.0));
        employees.add(new Employee("E004", "Phạm Hôn Lừng", false, Date.valueOf("1998-11-30"), "Hồ Chí Minh", "Marketing", "Marketing Executive", 1400.0));
        employees.add(new Employee("E005", "Hoàng Hoa Thám", true, Date.valueOf("2002-07-19"), "Nam Định", "IT", "Tester", 1100.0));
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee findById(String id) {
        return employees.stream().filter(e -> e.getEmpId().equals(id)).findFirst().orElse(null);
    }
}
