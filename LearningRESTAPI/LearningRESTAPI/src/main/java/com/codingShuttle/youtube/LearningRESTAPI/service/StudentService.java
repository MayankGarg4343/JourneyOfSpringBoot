package com.codingShuttle.youtube.LearningRESTAPI.service;

import com.codingShuttle.youtube.LearningRESTAPI.dto.AddStudentRequestDto;
import com.codingShuttle.youtube.LearningRESTAPI.dto.StudentDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);
    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);

    StudentDto updateAStudent(Long id, AddStudentRequestDto addStudentRequestDto);

    StudentDto updatePartialStudent(Long id, Map<String, Object> updates);
}
