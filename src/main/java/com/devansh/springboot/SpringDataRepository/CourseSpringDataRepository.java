package com.devansh.springboot.SpringDataRepository;

import com.devansh.springboot.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataRepository extends JpaRepository<Course,Integer> {


}
