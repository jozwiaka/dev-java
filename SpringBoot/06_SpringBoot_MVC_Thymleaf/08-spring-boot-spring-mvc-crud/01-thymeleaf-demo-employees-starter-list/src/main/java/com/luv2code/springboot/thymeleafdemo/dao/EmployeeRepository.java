package com.luv2code.springboot.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

import javax.swing.*;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();

//    1. Spring Data JPA will parse the method name - findAll() orderByLastNameAsc -> from Employee order by lastName asc
//    2. Looks for a specific format and pattern
//    3. Creates appriopriate query behind the scenes
}
