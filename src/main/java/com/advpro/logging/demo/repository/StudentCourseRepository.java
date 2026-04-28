package com.advpro.logging.demo.repository;

import com.advpro.logging.demo.entity.StudentCourse;
import com.advpro.logging.demo.entity.StudentCourseId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, StudentCourseId> {

    List<StudentCourse> findByStudent_Id(Long studentId);
}
