package com.example.practiceapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "devotee")
public class Devotee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int devoteeId;
    private String devoteeUserName;
    private String devoteeName;
    private int age;

    @ManyToMany
    @JoinTable(name = "devotee_courses",
            joinColumns = @JoinColumn(name = "devotee_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses;
}
