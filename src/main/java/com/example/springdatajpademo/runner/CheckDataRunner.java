package com.example.springdatajpademo.runner;

import com.example.springdatajpademo.SpringDataJpaDemoApplication;
import com.example.springdatajpademo.entity.Employee;
import com.example.springdatajpademo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CheckDataRunner implements CommandLineRunner, Ordered {

    private EmployeeRepository employeeRepository;

    private CheckDataRunner() {
    }

    @Autowired
    public CheckDataRunner(EmployeeRepository repository) {
        System.out.println("CheckDataRunner() - invoked, repository : " + repository);
        this.employeeRepository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(!SpringDataJpaDemoApplication.isOrderedInterfaceEnabled) {
            return;
        }
        System.out.println("CheckDataRunner - executed");
        List<Employee> employeeList = (List<Employee>) employeeRepository.findAll();
        System.out.println(employeeList);
        SpringDataJpaDemoApplication.setEmployeeList(employeeList);
    }

    @Override
    public int getOrder() {
        System.out.println("CheckDataRunner - getOrder() invoked");
        return 0;
    }
}
