package com.devansh.springboot.controller.intern;

import com.devansh.springboot.SpringDataRepository.CourseSpringDataRepository;
import com.devansh.springboot.SpringDataRepository.InternSpringDataRepository;
import com.devansh.springboot.SpringDataRepository.MentorSpringDataRepository;
import com.devansh.springboot.model.Course;
import com.devansh.springboot.model.Intern;
import com.devansh.springboot.model.Mentor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.*;

@Controller
public class UpdateIntern {

    @Autowired
    InternSpringDataRepository internRepository;
    @Autowired
    MentorSpringDataRepository mentorRepository;
    @Autowired
    CourseSpringDataRepository courseRepository;
    @GetMapping(path="/updateIntern/{id}")
    public String getInterns(@PathVariable("id") int internId, ModelMap model){
        Intern intern=internRepository.findById(internId).get();
        List<Mentor> mentorList=mentorRepository.findAll();
        List<Course> courseList=courseRepository.findAll();
        Set<Course> courseSet=new HashSet<>(intern.getAssignedCourses());
        model.put("intern",intern);
//        model.put("fName",intern.getFirstName());
//        model.put("lName",intern.getLastName());
//        model.put("college",intern.getCollege());
//        model.put("mentorId",intern.getMentor().getId());
//        model.put("coursesAssigned",intern.getAssignedCourses());
        model.put("mentorList",mentorList);
        model.put("courseList",courseList);
        model.put("courseSet",courseSet);
        return "updateIntern";
    }
    @PostMapping(path="/updateIntern/{id}",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RedirectView updateIntern(@PathVariable("id") int internId, @RequestParam(required = false) Map<String,String> requestBody, @RequestParam(value = "assignedCourses",required = false) List<Integer>courseList, ModelMap model){
        courseList=courseList==null?new ArrayList<>():courseList;
        requestBody=requestBody==null?new HashMap<>():requestBody;
        Mentor assignedMentor=requestBody.containsKey("mentor")
                ?mentorRepository.findById(Integer.parseInt(requestBody.get("mentor"))).orElse(null)
                :null;

        Intern newIntern=new Intern.InternBuilder()
                .setId(internId)
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

        return new RedirectView("/getIntern/"+internId);
    }

    @ResponseBody
    @PutMapping(path="/api/updateIntern",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Intern> updateInternApi(@Valid @RequestBody Intern intern){
        Intern updatedIntern=new Intern.InternBuilder()
                .setId(intern.getId())
                .setFirstName(intern.getFirstName())
                .setLastName(intern.getLastName())
                .setCollege(intern.getCollege())
                .setMentor(intern.getMentor())
                .setAssignedCourses(intern.getAssignedCourses())
                .build();
        internRepository.save(updatedIntern);
        return ResponseEntity.status(HttpStatus.OK).body(updatedIntern);
    }

}
