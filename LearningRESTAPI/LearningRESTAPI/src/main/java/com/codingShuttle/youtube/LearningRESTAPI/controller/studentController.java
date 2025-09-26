package com.codingShuttle.youtube.LearningRESTAPI.controller;


import com.codingShuttle.youtube.LearningRESTAPI.dto.AddStudentRequestDto;
import com.codingShuttle.youtube.LearningRESTAPI.dto.StudentDto;
import com.codingShuttle.youtube.LearningRESTAPI.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class studentController {

    private final StudentService studentService;

    // it helps to create the student related APIs.
    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudent(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }


    // in case if we want the multiple path variable.
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(id));
    }

    // Response Entity ek aise entity hai jisme hum status code aur bahut sari things bata sakte hai.

    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateAStudent(@PathVariable Long id, @RequestBody AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.ok(studentService.updateAStudent(id,addStudentRequestDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> updatePartialStudent(@PathVariable Long id, @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok(studentService.updatePartialStudent(id,updates));
    }
}
