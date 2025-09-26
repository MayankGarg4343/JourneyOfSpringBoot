package com.codingShuttle.youtube.LearningRESTAPI.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddStudentRequestDto {
    @NotBlank(message = "name is required")
    @Size(min = 3, max = 50, message = "name shold be of length 3 to 50")
    private String name;

    @Email
    @NotBlank(message = "email is required")
    private String email;
}

