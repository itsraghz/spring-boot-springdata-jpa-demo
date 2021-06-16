package com.example.springdatajpademo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastname;

    public Employee(String firstName, String lastname) {
        this.firstName = firstName;
        this.lastname = lastname;
    }
}
