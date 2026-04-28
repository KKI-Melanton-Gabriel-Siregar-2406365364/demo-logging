package com.advpro.logging.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String npm;

    @Column(nullable = false)
    private Double gpa;

    public Student() {
    }

    public Student(String name, String npm, Double gpa) {
        this.name = name;
        this.npm = npm;
        this.gpa = gpa;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNpm() {
        return npm;
    }

    public Double getGpa() {
        return gpa;
    }
}
