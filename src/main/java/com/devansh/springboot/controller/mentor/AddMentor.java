package com.devansh.springboot.controller.mentor;

import com.devansh.springboot.SpringDataRepository.InternSpringDataRepository;
import com.devansh.springboot.SpringDataRepository.MentorSpringDataRepository;
import com.devansh.springboot.model.Intern;
import com.devansh.springboot.model.Mentor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class AddMentor{

    @Autowired
    MentorSpringDataRepository mentorRepository;

    @GetMapping(path="/addMentor")
    public String getInterns(){
        return "addMentor";
    }
    @PostMapping(path="/addMentor",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void addIntern( @RequestParam Map<String,String> requestBody){

        System.out.println("addMentor Post Request");
        System.out.println(requestBody);

        Mentor newMentor=new Mentor(requestBody.get("name"));
        mentorRepository.save(newMentor);
//        return "addIntern";
    }
}