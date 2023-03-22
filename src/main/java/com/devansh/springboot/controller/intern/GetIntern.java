package com.devansh.springboot.controller.intern;

import com.devansh.springboot.SpringDataRepository.InternSpringDataRepository;
import com.devansh.springboot.exceptions.InternNotFoundException;
import com.devansh.springboot.model.Intern;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
