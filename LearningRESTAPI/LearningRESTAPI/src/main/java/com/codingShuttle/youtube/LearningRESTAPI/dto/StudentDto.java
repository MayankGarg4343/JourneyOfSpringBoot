package com.codingShuttle.youtube.LearningRESTAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // it used to generate all the getter and setter for the all variables.
@AllArgsConstructor // it creates the constructor for the class which used to contain the arguments of the all initialized variables.
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private String email;
}
