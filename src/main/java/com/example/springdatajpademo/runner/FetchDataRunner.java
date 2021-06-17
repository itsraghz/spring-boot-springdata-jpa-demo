package com.example.springdatajpademo.runner;

import com.example.springdatajpademo.SpringDataJpaDemoApplication;
import com.example.springdatajpademo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class FetchDataRunner implements CommandLineRunner, Ordered {

    private final EmployeeRepository employeeRepository;

    public FetchDataRunner(EmployeeRepository repository) {
        System.out.println("FetchDataRunner() - invoked, repository : " + repository);
        this.employeeRepository = repository;
    }
    @Override
    public void run(String... args) throws Exception {
        if(!SpringDataJpaDemoApplication.isOrderedInterfaceEnabled) {
            return;
        }
        System.out.println("FetchDataRunner - executed");
        System.out.println(employeeRepository.findEmployeesByLastnameContaining(" "));
    }

    @Override
    public int getOrder() {
        System.out.println("FetchDataRunner - getOrder() invoked");
        return 2;
    }
}
