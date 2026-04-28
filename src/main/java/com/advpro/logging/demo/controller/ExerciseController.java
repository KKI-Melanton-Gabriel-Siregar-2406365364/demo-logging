package com.advpro.logging.demo.controller;

import com.advpro.logging.demo.dto.StudentResponse;
import com.advpro.logging.demo.dto.StudentWithCoursesResponse;
import com.advpro.logging.demo.service.ExerciseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/seed-data-master")
    public String seedDataMaster() {
        return exerciseService.seedDataMaster();
    }

    @GetMapping("/seed-student-course")
    public String seedStudentCourse() {
        return exerciseService.seedStudentCourse();
    }

    @GetMapping("/all-student")
    public List<StudentWithCoursesResponse> getAllStudentWithCourses() {
        return exerciseService.getAllStudentWithCourses();
    }

    @GetMapping("/all-student-name")
    public List<String> getAllStudentName() {
        return exerciseService.getAllStudentName();
    }

    @GetMapping("/highest-gpa")
    public StudentResponse getHighestGpa() {
        return exerciseService.getHighestGpaStudent();
    }
}
