package com.advpro.logging.demo.dto;

import java.util.List;

public record StudentWithCoursesResponse(
        Long id,
        String name,
        String npm,
        Double gpa,
        List<CourseResponse> courses
) {
}
