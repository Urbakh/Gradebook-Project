package com.example.gradebook.services;

import com.example.gradebook.entities.Journal;
import com.example.gradebook.entities.Student;
import com.example.gradebook.dao.JournalDao;
import com.example.gradebook.dao.StudentDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final JournalDao journalDao;
    private final StudentDao studentDao;

    public List<Student> findAll() {
        return (List<Student>) studentDao.findAll();
    }

    public Optional<Student> getOne(Long studentId) {
        return studentDao.findById(studentId);
    }

    public Student getStudentName(String name) {
        return studentDao.findByName(name);
    }

    public Student create(Student student) {
        return studentDao.save(student);
    }

    public Student update(Student studentFromDb, Student student) {
        BeanUtils.copyProperties(student, studentFromDb,"id");
        return studentDao.save(studentFromDb);
    }

    @Transactional
    public void delete(Student student) {
        for (Journal journalRepo : journalDao.findAllByStudentId(student.getId())) {
            journalDao.delete(journalRepo);
        }
        studentDao.delete(student);
    }
}