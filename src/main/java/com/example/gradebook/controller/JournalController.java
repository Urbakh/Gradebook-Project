package com.example.gradebook.controller;

import com.example.gradebook.entities.Journal;
import com.example.gradebook.services.JournalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/journal")
public class JournalController {
    private final JournalService journalService;

    @GetMapping("/student/{studentId}")
    public Iterable<Journal> listByStudentId(@PathVariable("studentId") Long studentId) {
        return journalService.listByStudentId(studentId);
    }

    @GetMapping
    public List<Journal> list() {
        return journalService.findAll();
    }

    @GetMapping("{id}")
    public Optional<Journal> getOne(@PathVariable("id") Long id) {
        return journalService.getOne(id);
    }

    @PostMapping
    public Journal create(@RequestBody Journal journal) {
        return journalService.create(journal);
    }

    @PutMapping("{id}")
    public Journal update(
            @PathVariable("id") Journal journalFromDb,
            @RequestBody Journal journal
    ) {
        BeanUtils.copyProperties(journal, journalFromDb,"id");
        return journalService.update(journalFromDb, journal);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Journal journal) {
        journalService.delete(journal);
    }
}