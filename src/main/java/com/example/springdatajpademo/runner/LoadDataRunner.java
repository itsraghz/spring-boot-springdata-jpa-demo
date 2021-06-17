package com.example.springdatajpademo.runner;

import com.example.springdatajpademo.SpringDataJpaDemoApplication;
import com.example.springdatajpademo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class LoadDataRunner implements CommandLineRunner, Ordered {

    private EmployeeRepository employeeRepository;

    @Autowired
    public LoadDataRunner(EmployeeRepository repository) {
        System.out.println("LoadDataRunner() - invoked, repository : " + repository);
        this.employeeRepository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(!SpringDataJpaDemoApplication.isOrderedInterfaceEnabled) {
            return;
        }
        System.out.println("LoadDataRunner - executed");
        if(SpringDataJpaDemoApplication.getEmployeeList().size()>0) {
            System.out.println("The Employee DB has the tables and data in it already!");
            return;
        }
        System.out.println("LoadDataRunner - about to invoke - insertFourEmployees()");
        SpringDataJpaDemoApplication.insertFourEmployees(employeeRepository);
        System.out.println(employeeRepository.findAll());
    }

    @Override
    public int getOrder() {
        System.out.println("LoadDataRunner - getOrder() invoked");
        return 1;
    }
}
