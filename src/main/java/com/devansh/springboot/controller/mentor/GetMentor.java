package com.devansh.springboot.controller.mentor;

import com.devansh.springboot.SpringDataRepository.InternSpringDataRepository;
import com.devansh.springboot.SpringDataRepository.MentorSpringDataRepository;
import com.devansh.springboot.model.Intern;
import com.devansh.springboot.model.Mentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GetMentor {

    @Autowired
    MentorSpringDataRepository mentorRepository;


    @GetMapping("/getMentor/{id}")
    public String getInterns(@PathVariable("id") int mentorId, ModelMap model){
        System.out.println("getMentor GET Request");
        Mentor mentor=mentorRepository.findById(mentorId).get();

        model.put("name",mentor.getName());
        model.put("internsAssociated",mentor.getInternsAssociated());

        return "getMentor";

    }

}

