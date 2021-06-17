package com.example.springdatajpademo.runner;

import com.example.springdatajpademo.SpringDataJpaDemoApplication;
import com.example.springdatajpademo.entity.Employee;
import com.example.springdatajpademo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(0)
public class CheckDataRunnerWithOrder implements CommandLineRunner {

    private EmployeeRepository employeeRepository;

    private CheckDataRunnerWithOrder() {
    }

    @Autowired
    public CheckDataRunnerWithOrder(EmployeeRepository repository) {
        System.out.println("CheckDataRunnerWithOrder() - invoked, repository : " + repository);
        this.employeeRepository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(!SpringDataJpaDemoApplication.isOrderAnnotationEnabled) {
            return;
        }
        System.out.println("CheckDataRunnerWithOrder - executed");
        List<Employee> employeeList = (List<Employee>) employeeRepository.findAll();
        System.out.println(employeeList);
        SpringDataJpaDemoApplication.setEmployeeList(employeeList);
    }

    public int getOrder() {
        System.out.println("CheckDataRunnerWithOrder - getOrder() invoked");
        return 0;
    }
}
