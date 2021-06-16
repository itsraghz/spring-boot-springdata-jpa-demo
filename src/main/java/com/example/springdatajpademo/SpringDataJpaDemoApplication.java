package com.example.springdatajpademo;

import com.example.springdatajpademo.entity.Employee;
import com.example.springdatajpademo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaDemoApplication.class, args);
    }

    private void insertFourEmployees(EmployeeRepository repository) {
        repository.save(new Employee("Dalia", "Abo Sheasha"));
        repository.save(new Employee("Trisha", "Gee"));
        repository.save(new Employee("Helen", "Scott"));
        repository.save(new Employee("Mala", "Gupta"));
    }

    @Bean
    public CommandLineRunner run(EmployeeRepository repository) {
        return (args -> {
            insertFourEmployees(repository);
            System.out.println(repository.findAll());
        });
    }

    @Bean
    public CommandLineRunner run2(EmployeeRepository repository) {
        return (args -> {
            System.out.println(repository.findEmployeesByLastnameContaining(" "));
        });
    }
}
