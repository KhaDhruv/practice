package com.coforge.student.controller;

import com.coforge.student.model.Student;
import com.coforge.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ExceptionDepthComparator;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    IStudentService service;


    @PostMapping("/save")
    public ResponseEntity<String> saveStudentData(
            @RequestBody List<Student> student
    ) {
        ResponseEntity<String> response;
        List<Student> id = service.save(student);
        String body = "saved student -" + id;

        try {
            response = new ResponseEntity(body, HttpStatus.CREATED);

            return response;

        } catch (Exception exception) {
            return new ResponseEntity<>("student not saved", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getAllData")
    public ResponseEntity<List<Student>> getAllStudentData() {

        List<Student> studentList = service.findAllStuden();

        ResponseEntity response;

        try {
            response = new ResponseEntity("list of student" + studentList.stream().collect(Collectors.toList()), HttpStatus.OK);


        } catch (Exception exception) {
            response = new ResponseEntity("Student data are not available", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Student> getStudentDataById(
            @PathVariable("id") Integer id
    ) {
        Student student = service.findStudentById(id);
        ResponseEntity response;

        try {
            response = new ResponseEntity("student data by id" + student, HttpStatus.OK);
        } catch (Exception exception) {
            response = new ResponseEntity("student data is not found", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;

    }
}
