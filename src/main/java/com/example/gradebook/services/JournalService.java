package com.example.gradebook.services;

import com.example.gradebook.entities.Journal;
import com.example.gradebook.dao.JournalDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JournalService {
    private final JournalDao journalDao;

    public List<Journal> findAll() {
        return (List<Journal>) journalDao.findAll();
    }

    public Optional<Journal> getOne(Long id) {
        return journalDao.findById(id);
    }

    public Iterable<Journal> listByStudentId(Long studentId) {
        return journalDao.findAllByStudentId(studentId);
    }

    public Journal create(Journal journal) {
        return journalDao.save(journal);
    }

    public Journal update(Journal journalFromDb, Journal journal) {
        BeanUtils.copyProperties(journal, journalFromDb,"id");
        return journalDao.save(journalFromDb);
    }

    public void delete(Journal journal) {
        journalDao.delete(journal);
    }
}