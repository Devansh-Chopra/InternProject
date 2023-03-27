package com.devansh.springboot;

import com.devansh.springboot.SpringDataRepository.InternSpringDataRepository;
import com.devansh.springboot.SpringDataRepository.MentorSpringDataRepository;
import com.devansh.springboot.model.Intern;
import com.devansh.springboot.model.Mentor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.devansh.repository","com.devansh.springboot"})
public class StudentServicesApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(StudentServicesApplication.class);
	@Autowired
	InternSpringDataRepository internRepository;
	@Autowired
	MentorSpringDataRepository mentorRepository;


	public static void main(String[] args) {
//		var context=SpringApplication.run(StudentServicesApplication.class, args);
		SpringApplication.run(StudentServicesApplication.class, args);
//		InternJpaRepository internJpaRepository=context.getBean(InternJpaRepository.class);

//		internJpaRepository.insert(new Intern(2,"Devansh","Chopra","ADGITM",new ArrayList<Course>(Arrays.asList(new Course(1,"Maths")))));

	}

	@Override
	public void run(String... args) throws Exception {


	}
}
