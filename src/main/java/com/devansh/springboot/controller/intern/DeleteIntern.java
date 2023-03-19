package com.devansh.springboot.controller.intern;

import com.devansh.springboot.SpringDataRepository.InternSpringDataRepository;
import com.devansh.springboot.SpringDataRepository.MentorSpringDataRepository;
import com.devansh.springboot.exceptions.InternNotFoundException;
import com.devansh.springboot.model.Intern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;
import java.util.Optional;

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

        @ResponseBody
        @DeleteMapping(path = "/api/deleteIntern/{id}")
        public ResponseEntity<Intern> deleteInternApi(@PathVariable("id") int internId){
            System.out.println("deleteInternApi Delete Request");
            Optional<Intern> deletedIntern = internRepository.findById(internId);
            if(deletedIntern.isEmpty()){
                throw new InternNotFoundException(internId);
            }
            internRepository.deleteById(internId);
            return ResponseEntity.status(HttpStatus.OK).body(deletedIntern.get());
        }

    }
