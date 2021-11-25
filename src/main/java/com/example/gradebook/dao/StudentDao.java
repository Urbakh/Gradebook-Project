package com.example.gradebook.dao;

import com.example.gradebook.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentDao extends CrudRepository<Student, Long> {
}