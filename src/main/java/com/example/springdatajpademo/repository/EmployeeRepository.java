package com.example.springdatajpademo.repository;

import com.example.springdatajpademo.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findEmployeesByLastnameContaining(String text);
}
