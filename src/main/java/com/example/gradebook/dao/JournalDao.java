package com.example.gradebook.dao;

import com.example.gradebook.entities.Journal;
import org.springframework.data.repository.CrudRepository;

public interface JournalDao extends CrudRepository<Journal, Long> {
    Iterable<Journal> findAllByStudentId(Long studentId);
}