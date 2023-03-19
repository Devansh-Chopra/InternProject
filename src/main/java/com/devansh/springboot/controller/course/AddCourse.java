package com.devansh.springboot.controller.course;

import com.devansh.springboot.SpringDataRepository.CourseSpringDataRepository;
import com.devansh.springboot.SpringDataRepository.InternSpringDataRepository;
import com.devansh.springboot.SpringDataRepository.MentorSpringDataRepository;
import com.devansh.springboot.model.Course;
import com.devansh.springboot.model.Intern;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@Controller
public class AddCourse {
    @Autowired
    CourseSpringDataRepository courseRepository;

    @GetMapping(path="/addCourse")
    public String getCourses(){
        return "addCourse";
    }

    @PostMapping(path="/addCourse",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Course> addCourse(@RequestParam Map<String,String> requestBody){
        System.out.println("addCourse Post Request");
        Course newCourse=new Course(requestBody.get("name"));
        courseRepository.save(newCourse);
        return new ResponseEntity<>(newCourse,HttpStatus.CREATED);
    }


    @ResponseBody
    @PostMapping(path="/api/addCourse",consumes = MediaType.APPLICATION_JSON_VALUE)
//    consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
    public ResponseEntity<Course> addCourseApi(@Valid @RequestBody Course course){
        System.out.println("addCourse Post Request");
        Course newCourse=new Course(course.getName());
        courseRepository.save(newCourse);
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }
}