package com.codingShuttle.youtube.LearningRESTAPI.service.impl;

import com.codingShuttle.youtube.LearningRESTAPI.dto.AddStudentRequestDto;
import com.codingShuttle.youtube.LearningRESTAPI.dto.StudentDto;
import com.codingShuttle.youtube.LearningRESTAPI.entity.StudentEntity;
import com.codingShuttle.youtube.LearningRESTAPI.repositiory.StudentRepository;
import com.codingShuttle.youtube.LearningRESTAPI.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor // used to make the constructor for the final classes.
public class StudentServiceImpl implements StudentService {

    public final StudentRepository studentRepository;
    public final ModelMapper modelMapper;

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student id not found by id: " + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public List<StudentDto> getAllStudents(){
        List<StudentEntity> students = studentRepository.findAll();
        List<StudentDto> studentDtoList= students
                .stream()
                .map(StudentEntity -> modelMapper.map(StudentEntity, StudentDto.class)).toList();
        return studentDtoList;
    }

    @Override
    public StudentDto getStudentById(Long id) {
        StudentEntity student = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("student not found by id: "+ id));
//        return new StudentDto(student.getId(),student.getName(),student.getEmail());
        //🌟 in place of writing this long code we will use the ModelMapper.
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        StudentEntity newstudent = modelMapper.map(addStudentRequestDto, StudentEntity.class);
        StudentEntity student = studentRepository.save(newstudent);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto updateAStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        StudentEntity student = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("student not found by id: "+ id));
        modelMapper.map(addStudentRequestDto,student);
        student = studentRepository.save(student);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        StudentEntity student = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("student not found by id: "+ id));

        updates.forEach((field,value) -> {
            switch(field){
                case "name": student.setName((String) value);
                break;
                case "email": student.setEmail((String) value);
                break;
                default:
                    throw new IllegalArgumentException("field is not supported");
            }
        });
        StudentEntity savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent,StudentDto.class);
    }
}
