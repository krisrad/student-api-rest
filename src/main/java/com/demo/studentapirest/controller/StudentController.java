package com.demo.studentapirest.controller;

import ch.qos.logback.classic.Level;
import com.demo.studentapirest.entity.Student;
import com.demo.studentapirest.request.CreateStudentRequest;
import com.demo.studentapirest.response.StudentResponse;
import com.demo.studentapirest.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import javax.validation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    StudentService studentService;

    Logger logger;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
        this.logger = LoggerFactory.getLogger(StudentController.class);
    }

    @GetMapping("getAll")
    public List<StudentResponse> getAllStudents () {
        logger.info("Entering getAllStudents...");

        List<Student> studentList = studentService.getAllStudents();
        List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

        studentList.stream().forEach(student -> {
            studentResponseList.add(new StudentResponse(student));
        });

        logger.info("Exiting getAllStudents...");

        return studentResponseList;
    }

    @GetMapping("getFirstNameById/{id}")
    public String getFirstNameById (@PathVariable long id) {
        logger.info("Entering getFirstNameById {}.", id);
        String firstNameById = studentService.getFirstNameById(id);
        logger.info("Exiting getFirstNameById {}. Result: {} ", id, firstNameById);
        return firstNameById;
    }

    @GetMapping("getLastNameById/{id}")
    public String getLastNameById (@PathVariable long id) {
        logger.info("Entering getLastNameById {}.", id);
        String lastNameById = studentService.getLastNameById(id);
        logger.info("Exiting getLastNameById {}. Result: {} ", id, lastNameById);
        return lastNameById;
    }

    @PostMapping("create")
    public StudentResponse createStudent (@Valid @RequestBody CreateStudentRequest createStudentRequest) {
        logger.info("Entering createStudent.");

        Student student = studentService.createStudent(createStudentRequest);

        logger.info("Exiting createStudent.");

        return new StudentResponse(student);
    }


}
