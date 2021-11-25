package com.example.gradebook.domain;
//Пакет с сущностями обыно называют entities, но зависит от компании
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "journal")
@Data
public class Journal {

    @Id
    @GeneratedValue
    private Long id;

    private String schoolItems;

    private Integer grade;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate date;

    private Long studentId;
}