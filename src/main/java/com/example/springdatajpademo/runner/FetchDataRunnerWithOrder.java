package com.example.springdatajpademo.runner;

import com.example.springdatajpademo.SpringDataJpaDemoApplication;
import com.example.springdatajpademo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class FetchDataRunnerWithOrder implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    public FetchDataRunnerWithOrder(EmployeeRepository repository) {
        System.out.println("FetchDataRunnerWithOrder() - invoked, repository : " + repository);
        this.employeeRepository = repository;
    }
    @Override
    public void run(String... args) throws Exception {
        if(!SpringDataJpaDemoApplication.isOrderAnnotationEnabled) {
            return;
        }
        System.out.println("FetchDataRunnerWithOrder - executed");
        System.out.println(employeeRepository.findEmployeesByLastnameContaining(" "));
    }

    public int getOrder() {
        System.out.println("FetchDataRunnerWithOrder - getOrder() invoked");
        return 2;
    }
}
