package com.codingShuttle.youtube.LearningRESTAPI.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity // by using this we can connect our table to the postgres database.

@Getter // ----
//             |--->>> they are being used to update the value of the variables.
@Setter // ----

public class StudentEntity {
    @Id // by this our id keeps generating.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this helps to make the id from the starting of 1,2,3.
    private Long id;
    private String name;
    private String email;
    //Notes:
    // 🌟jab humane database me data ko add Kia hai to isme inhe direct nahi pata chalta ki data add hua hai.
    // 🌟to inki value ko update karne ke liye hume inke getter and setters banane padte hai.
}