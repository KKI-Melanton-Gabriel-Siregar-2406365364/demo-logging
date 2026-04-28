package com.advpro.logging.demo.service;

import com.advpro.logging.demo.dto.CourseResponse;
import com.advpro.logging.demo.dto.StudentResponse;
import com.advpro.logging.demo.dto.StudentWithCoursesResponse;
import com.advpro.logging.demo.entity.Course;
import com.advpro.logging.demo.entity.Student;
import com.advpro.logging.demo.entity.StudentCourse;
import com.advpro.logging.demo.repository.CourseRepository;
import com.advpro.logging.demo.repository.StudentCourseRepository;
import com.advpro.logging.demo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;

@Service
public class ExerciseService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentCourseRepository studentCourseRepository;

    private final Random random = new Random(7);

    public ExerciseService(
            StudentRepository studentRepository,
            CourseRepository courseRepository,
            StudentCourseRepository studentCourseRepository
    ) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.studentCourseRepository = studentCourseRepository;
    }

    @Transactional
    public String seedDataMaster() {
        if (courseRepository.count() == 0) {
            List<Course> courses = new ArrayList<>();
            for (int i = 1; i <= 25; i++) {
                String code = String.format(Locale.US, "CS%04d", i);
                courses.add(new Course(code, "Course " + i));
            }
            courseRepository.saveAll(courses);
        }

        if (studentRepository.count() == 0) {
            List<Student> students = new ArrayList<>();
            for (int i = 1; i <= 2000; i++) {
                String npm = String.format(Locale.US, "2306%06d", i);
                double gpa = 2.0 + (2.0 * random.nextDouble());
                students.add(new Student("Student " + i, npm, Math.round(gpa * 100.0) / 100.0));
            }
            studentRepository.saveAll(students);
        }

        return "Seeded courses and students.";
    }

    @Transactional
    public String seedStudentCourse() {
        if (studentCourseRepository.count() > 0) {
            return "student_courses already seeded.";
        }

        List<Student> students = studentRepository.findAll();
        List<Course> courses = courseRepository.findAll();
        if (students.isEmpty() || courses.isEmpty()) {
            return "Please run /seed-data-master first.";
        }

        List<StudentCourse> studentCourses = new ArrayList<>();
        for (Student student : students) {
            int coursePerStudent = 3 + random.nextInt(3);
            Set<Integer> pickedCourseIndexes = new HashSet<>();
            while (pickedCourseIndexes.size() < coursePerStudent) {
                pickedCourseIndexes.add(random.nextInt(courses.size()));
            }

            for (Integer courseIndex : pickedCourseIndexes) {
                Course course = courses.get(courseIndex);
                studentCourses.add(new StudentCourse(student, course));
            }
        }

        studentCourseRepository.saveAll(studentCourses);
        return "Seeded student_courses.";
    }

    public List<StudentWithCoursesResponse> getAllStudentWithCourses() {
        List<Student> students = studentRepository.findAll();
        List<StudentWithCoursesResponse> results = new ArrayList<>();

        for (Student student : students) {
            List<StudentCourse> relations = studentCourseRepository.findByStudent_Id(student.getId());
            List<CourseResponse> courses = relations.stream()
                    .map(sc -> new CourseResponse(
                            sc.getCourse().getId(),
                            sc.getCourse().getCode(),
                            sc.getCourse().getName()
                    ))
                    .toList();

            results.add(new StudentWithCoursesResponse(
                    student.getId(),
                    student.getName(),
                    student.getNpm(),
                    student.getGpa(),
                    courses
            ));
        }

        return results;
    }

    public List<String> getAllStudentName() {
        return studentRepository.findAll().stream()
                .map(Student::getName)
                .toList();
    }

    public StudentResponse getHighestGpaStudent() {
        Student student = studentRepository.findTopByOrderByGpaDesc()
                .orElseThrow(() -> new IllegalStateException("No student data found"));
        return new StudentResponse(student.getId(), student.getName(), student.getNpm(), student.getGpa());
    }
}
