package com.codeshuttle.youtube.lecture_5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@ToString
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    @ToString.Exclude // this is being used to not print that statement in the console.
    private LocalDate birthDate;
    private String email;
    private String gender;
}
