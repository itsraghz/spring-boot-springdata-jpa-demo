package com.example.springdatajpademo.runner;

import com.example.springdatajpademo.SpringDataJpaDemoApplication;
import com.example.springdatajpademo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class LoadDataRunnerWithOrder implements CommandLineRunner {

    private EmployeeRepository employeeRepository;

    @Autowired
    public LoadDataRunnerWithOrder(EmployeeRepository repository) {
        System.out.println("LoadDataRunnerWithOrder() - invoked, repository : " + repository);
        this.employeeRepository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(!SpringDataJpaDemoApplication.isOrderAnnotationEnabled) {
            return;
        }
        System.out.println("LoadDataRunnerWithOrder - executed");
        if(SpringDataJpaDemoApplication.getEmployeeList().size()>0) {
            System.out.println("The Employee DB has the tables and data in it already!");
            return;
        }
        System.out.println("LoadDataRunnerWithOrder - about to invoke - insertFourEmployees()");
        SpringDataJpaDemoApplication.insertFourEmployees(employeeRepository);
        System.out.println(employeeRepository.findAll());
    }

    public int getOrder() {
        System.out.println("LoadDataRunnerWithOrder - getOrder() invoked");
        return 1;
    }
}
