package com.melazab.demo.rest;

import com.melazab.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data.. only once!
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Mariam","Nawar"));
        theStudents.add(new Student("Mahmoud","Elazab"));
        theStudents.add(new Student("Lionel","Messi"));

    }

    // define endpoint for "/students" - returns a list of students

    @GetMapping("/students")
    public List<Student> getStudents(){


        return theStudents;
    }

    // define endpoint for "/students/{studentId}" - return student by id
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        // just index into the list
        return theStudents.get(studentId);

    }
}
