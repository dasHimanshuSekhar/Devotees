package com.example.practiceapi.repository;

import com.example.practiceapi.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {
//    Optional<Course> findAllByUse(String courseName);
}