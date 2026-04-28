package com.advpro.logging.demo.repository;

import com.advpro.logging.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
