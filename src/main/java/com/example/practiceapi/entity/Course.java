package com.example.practiceapi.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int courseId;
    private String courseName;

    @ManyToMany(mappedBy = "courses")
    private Set<Devotee> devotees;
}
