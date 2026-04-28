package com.advpro.logging.demo.repository;

import com.advpro.logging.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findTopByOrderByGpaDesc();

    @Query("select s.name from Student s")
    List<String> findAllNames();
}
