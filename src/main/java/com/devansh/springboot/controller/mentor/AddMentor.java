package com.devansh.springboot.controller.mentor;

import com.devansh.springboot.SpringDataRepository.InternSpringDataRepository;
import com.devansh.springboot.SpringDataRepository.MentorSpringDataRepository;
import com.devansh.springboot.model.Intern;
import com.devansh.springboot.model.Mentor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class AddMentor{

    @Autowired
    MentorSpringDataRepository mentorRepository;

    @GetMapping(path="/addMentor")
    public String addMentor(){
        return "addMentor";
    }
    @PostMapping(path="/addMentor",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void addMentor( @RequestParam Map<String,String> requestBody){

        System.out.println("addMentor Post Request");
        System.out.println(requestBody);

        Mentor newMentor=new Mentor(requestBody.get("name"));
        mentorRepository.save(newMentor);
//        return "addIntern";
    }

    @ResponseBody
    @PostMapping(path = "/api/addMentor")
    public ResponseEntity AddMentorApi(@Valid @RequestBody Mentor mentor){

        Mentor newMentor=new Mentor(mentor.getName());
        mentorRepository.save(newMentor);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMentor);

    }
}