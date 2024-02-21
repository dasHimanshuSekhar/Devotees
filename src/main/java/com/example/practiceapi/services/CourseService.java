package com.example.practiceapi.services;

import com.example.practiceapi.pojo.CourseRegisterReq;
import com.example.practiceapi.pojo.CourseRegistrationRes;

public interface CourseService {

    CourseRegistrationRes register(CourseRegisterReq courseRegisterReq);
}
