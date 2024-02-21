package com.example.practiceapi.controller;

import com.example.practiceapi.pojo.CourseRegisterReq;
import com.example.practiceapi.pojo.CourseRegistrationRes;
import com.example.practiceapi.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("test")
    private String testCourse(){
        return "prabhupada teachings !";
    }

    @PostMapping("register")
    private ResponseEntity<CourseRegistrationRes> register(@RequestBody @Valid CourseRegisterReq courseRegisterReq){
        CourseRegistrationRes courseRegistrationRes = courseService.register(courseRegisterReq);
        return new ResponseEntity<>(courseRegistrationRes, HttpStatus.CREATED);
    }
}
