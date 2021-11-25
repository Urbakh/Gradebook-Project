package com.example.gradebook.repository;

import com.example.gradebook.domain.Journal;
import org.springframework.data.repository.CrudRepository;

//Пакет и сами классы обычно именуют dao (JournalDao например)
public interface JournalRepository extends CrudRepository<Journal, Long> {
    Iterable<Journal> findAllByStudentId(Long studentId);
}