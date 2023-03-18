package com.devansh.springboot.controller.course;

import com.devansh.springboot.SpringDataRepository.CourseSpringDataRepository;
import com.devansh.springboot.SpringDataRepository.InternSpringDataRepository;
import com.devansh.springboot.SpringDataRepository.MentorSpringDataRepository;
import com.devansh.springboot.model.Course;
import com.devansh.springboot.model.Intern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
@Controller
public class AddCourse {
    @Autowired
    CourseSpringDataRepository courseRepository;

    @GetMapping(path="/addCourse")
    public String getCourses(){
        return "addCourse";
    }
    @PostMapping(path="/addCourse",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void addCourse(@RequestParam Map<String,String> requestBody){
        System.out.println("addCourse Post Request");
        System.out.println(requestBody);

        Course newCourse=new Course(requestBody.get("name"));
        courseRepository.save(newCourse);
    }
}