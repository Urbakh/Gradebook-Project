package com.example.gradebook.repository;

import com.example.gradebook.domain.Student;
import org.springframework.data.repository.CrudRepository;
//dao
public interface StudentRepository extends CrudRepository<Student, Long> {
}