package mypackage.restcrud.dao;

import mypackage.restcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members")
//spring.data.rest.base-path=/api //application.properties
//api/members
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//<Employee,... -> add 's' at the end -> /employees
}
