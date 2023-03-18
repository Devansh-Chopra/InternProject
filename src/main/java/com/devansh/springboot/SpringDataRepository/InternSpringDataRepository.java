package com.devansh.springboot.SpringDataRepository;

import com.devansh.springboot.model.Intern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface InternSpringDataRepository extends JpaRepository<Intern,Integer> {
}
