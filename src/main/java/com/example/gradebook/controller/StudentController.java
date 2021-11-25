package com.example.gradebook.controller;

import com.example.gradebook.entities.Student;
import com.example.gradebook.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<Student> list() {
        return studentService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Student> getOne(@PathVariable("id") Long studentId) {
        return studentService.getOne(studentId);
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentService.create(student);
    }

    @PutMapping("{id}")
    public Student update(
            @PathVariable("id") Student studentFromDb,
            @RequestBody Student student
    ) {
        BeanUtils.copyProperties(student, studentFromDb,"id");
        return studentService.update(studentFromDb,student);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Student student) {
        studentService.delete(student);
    }
}