package com.advpro.logging.demo.repository;

import com.advpro.logging.demo.entity.StudentCourse;
import com.advpro.logging.demo.entity.StudentCourseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, StudentCourseId> {

    List<StudentCourse> findByStudent_Id(Long studentId);

    @Query("select sc from StudentCourse sc join fetch sc.course")
    List<StudentCourse> findAllWithCourse();
}
