package com.example.gradebook.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String lastName;

}