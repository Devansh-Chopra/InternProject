package com.devansh.springboot.controller.intern;

import com.devansh.springboot.SpringDataRepository.InternSpringDataRepository;
import com.devansh.springboot.SpringDataRepository.MentorSpringDataRepository;
import com.devansh.springboot.model.Intern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GetIntern {

    @Autowired
    InternSpringDataRepository internRepository;


    @GetMapping("/getIntern/{id}")
    public String getInterns(@PathVariable("id") int internId,ModelMap model){
        Intern intern=internRepository.findById(internId).get();
        model.put("intern",intern);
        return "getIntern";

    }

}
