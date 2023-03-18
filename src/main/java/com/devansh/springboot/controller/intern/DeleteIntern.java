package com.devansh.springboot.controller.intern;

import com.devansh.springboot.SpringDataRepository.InternSpringDataRepository;
import com.devansh.springboot.SpringDataRepository.MentorSpringDataRepository;
import com.devansh.springboot.model.Intern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
public class DeleteIntern {

        @Autowired
        InternSpringDataRepository internRepository;




        @GetMapping(path="/deleteIntern/{id}")
        public RedirectView deleteIntern(@PathVariable("id") int internId, @RequestParam Map<String,String> requestBody){
            System.out.println("deleteIntern Get Request");
            internRepository.deleteById(internId);
            return new RedirectView("/");
        }
    }
