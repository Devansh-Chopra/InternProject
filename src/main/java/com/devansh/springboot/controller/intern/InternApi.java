package com.devansh.springboot.controller.intern;

import com.devansh.springboot.SpringDataRepository.InternSpringDataRepository;
import com.devansh.springboot.exceptions.InternNotFoundException;
import com.devansh.springboot.model.Intern;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/api/intern")
public class InternApi {

    @Autowired
    InternSpringDataRepository internRepository;

    @PostMapping
    public ResponseEntity<Intern> addInternApi(@Valid @RequestBody Intern intern){
        Intern newIntern=new Intern.InternBuilder()
                .setFirstName(intern.getFirstName())
                .setLastName(intern.getLastName())
                .setCollege(intern.getCollege())
                .setMentor(intern.getMentor())
                .setAssignedCourses(intern.getAssignedCourses())
                .build();
        internRepository.save(newIntern);
        return ResponseEntity.status(HttpStatus.CREATED).body(newIntern);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteInternApi(@RequestParam("id") int internId){
        System.out.println("deleteInternApi Delete Request");
        Optional<Intern> deletedIntern = internRepository.findById(internId);
        if(deletedIntern.isEmpty()){
            throw new InternNotFoundException(internId);
        }
        internRepository.deleteById(internId);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }

    @PutMapping
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

    @GetMapping
    public ResponseEntity<Intern> getInternApi(@RequestParam("id")int internId){
        System.out.println("GET /api/intern?id="+internId);
        Optional<Intern> intern=internRepository.findById(internId);
        if(intern.isEmpty()){
            throw new InternNotFoundException(internId);
        }
        return ResponseEntity.status(HttpStatus.OK).body(intern.get());
    }

    @Autowired
    Patcher patcher;

    @PatchMapping
    public ResponseEntity<Intern> patchInternApi( @RequestBody Intern updatedIntern){
        Intern existingIntern=internRepository.findById(updatedIntern.getId())
                .orElseThrow(()->new InternNotFoundException(updatedIntern.getId()));
        try {
            patcher.internPatcher(existingIntern, updatedIntern);
            internRepository.save(existingIntern);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).body(existingIntern);
    }


//monoflux
    @GetMapping(path = "/restTemplate")
    public ResponseEntity<Intern> rest(){
        ResponseEntity<Intern> responseEntity=new RestTemplate()
                .getForEntity("http://localhost:8080/api/intern?id=105",Intern.class);
        Intern intern=responseEntity.getBody();
        return ResponseEntity.status(HttpStatus.OK).body(intern);
    }



}
