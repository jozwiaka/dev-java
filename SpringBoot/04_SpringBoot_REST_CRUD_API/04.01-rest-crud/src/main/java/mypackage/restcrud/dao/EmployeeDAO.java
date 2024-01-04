package mypackage.restcrud.dao;

import mypackage.restcrud.entity.Employee;
import mypackage.restcrud.service.EmployeeService;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);

}
