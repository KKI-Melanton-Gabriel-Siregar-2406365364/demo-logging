package com.advpro.logging.demo.repository;

import com.advpro.logging.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findTopByOrderByGpaDesc();
}
