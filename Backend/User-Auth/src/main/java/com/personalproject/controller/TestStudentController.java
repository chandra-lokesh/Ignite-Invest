package com.personalproject.controller;

import com.personalproject.model.TestStudent;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestStudentController {

    List<TestStudent> students= new ArrayList<>();

    TestStudentController(){
        this.students.add(new TestStudent(1, "chandra", 50));
        this.students.add(new TestStudent(2, "lokesh", 60));
    }

    @GetMapping("/students")
    List<TestStudent> getAllStudents(){
        return students;
    }

    @PostMapping("/students")
    void addStudent(@RequestBody TestStudent student){
        this.students.add(student);
    }
}