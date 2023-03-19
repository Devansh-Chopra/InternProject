package com.devansh.springboot.controller.intern;

import com.devansh.springboot.SpringDataRepository.InternSpringDataRepository;
import com.devansh.springboot.exceptions.InternNotFoundException;
import com.devansh.springboot.model.Intern;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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


    @ResponseBody
    @GetMapping(path="/api/getIntern/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Intern> getInternApi(@Valid @PathVariable("id")int internId){
        Optional<Intern> intern=internRepository.findById(internId);
        if(intern.isEmpty()){
            throw new InternNotFoundException(internId);
        }

        return ResponseEntity.status(HttpStatus.OK).body(intern.get());
    }


}
