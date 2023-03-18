package com.devansh.springboot.controller;


import com.devansh.springboot.SpringDataRepository.CourseSpringDataRepository;
import com.devansh.springboot.SpringDataRepository.InternSpringDataRepository;
import com.devansh.springboot.SpringDataRepository.MentorSpringDataRepository;

import com.devansh.springboot.model.Course;
import com.devansh.springboot.model.Intern;
import com.devansh.springboot.model.Mentor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.List;


@Controller
public class HomePage {
    @Autowired
    CourseSpringDataRepository courseRepository;
    @Autowired
    InternSpringDataRepository internRepository;
    @Autowired
    MentorSpringDataRepository mentorRepository;

    @GetMapping({"/"})
    public String HomePage(ModelMap model) {

        List<Intern> internList = internRepository.findAll();
        List<Mentor> mentorList=mentorRepository.findAll();
        List<Course> courseList=courseRepository.findAll();
        model.put("internList",internList);
        model.put("mentorList",mentorList);
        model.put("courseList",courseList);
        return  "welcome";
    }





}
