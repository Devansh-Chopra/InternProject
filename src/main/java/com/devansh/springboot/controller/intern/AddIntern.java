package com.devansh.springboot.controller.intern;

import com.devansh.springboot.model.Course;
import com.devansh.springboot.model.Intern;
import com.devansh.springboot.model.Mentor;
import com.devansh.springboot.SpringDataRepository.CourseSpringDataRepository;
import com.devansh.springboot.SpringDataRepository.InternSpringDataRepository;
import com.devansh.springboot.SpringDataRepository.MentorSpringDataRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.view.RedirectView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AddIntern {

    @Autowired
    InternSpringDataRepository internRepository;
    @Autowired
    MentorSpringDataRepository mentorRepository;

    @Autowired
    CourseSpringDataRepository courseRepository;

    @GetMapping(path="/addIntern")
    public String getIntern(ModelMap model){
        List<Course> courseList=courseRepository.findAll();
        model.put("courseList",courseList);
        List<Mentor> mentorList=mentorRepository.findAll();
        model.put("mentorList",mentorList);
        return "addIntern";
    }
    @PostMapping(path="/addIntern",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RedirectView addIntern(@RequestParam(required = false) Map<String,String> requestBody , @RequestParam(value = "assignedCourses",required = false) List<Integer>courseList){
        courseList=courseList==null?new ArrayList<>():courseList;
        requestBody=requestBody==null?new HashMap<>():requestBody;
        Mentor assignedMentor=requestBody.containsKey("mentor")
                ?mentorRepository.findById(Integer.parseInt(requestBody.get("mentor"))).orElse(null)
                :null;

        Intern newIntern=new Intern.InternBuilder()
                .setFirstName(requestBody.get("firstName"))
                .setLastName(requestBody.get("lastName"))
                .setCollege(requestBody.get("college"))
                .setMentor(assignedMentor)
                .build();

        List<Course> assignedCourses=newIntern.getAssignedCourses();
        for(int courseId:courseList){
            assignedCourses.add(courseRepository.findById(courseId).get());
        }
        internRepository.save(newIntern);
        return new RedirectView("/");
    }


}
