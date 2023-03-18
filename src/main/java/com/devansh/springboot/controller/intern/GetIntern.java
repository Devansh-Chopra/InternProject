package com.devansh.springboot.controller.intern;

import com.devansh.springboot.SpringDataRepository.InternSpringDataRepository;
import com.devansh.springboot.exceptions.InternNotFoundException;
import com.devansh.springboot.model.Intern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class GetIntern {

    @Autowired
    InternSpringDataRepository internRepository;


    @GetMapping("/getIntern/{id}")
    public String getInterns(@PathVariable("id") int internId,ModelMap model){
        Optional<Intern> intern=internRepository.findById(internId);
        if(intern.isEmpty()){
            throw new InternNotFoundException(internId);
        }
        model.put("intern",intern.get());
        return "getIntern";

    }

}
