package com.devansh.springboot.SpringDataRepository;

import com.devansh.springboot.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorSpringDataRepository extends JpaRepository<Mentor,Integer> {
}
