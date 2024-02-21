package com.example.practiceapi.services;

import com.example.practiceapi.entity.Course;
import com.example.practiceapi.pojo.CourseRegisterReq;
import com.example.practiceapi.pojo.CourseRegistrationRes;
import com.example.practiceapi.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepo courseRepo;
    @Override
    public CourseRegistrationRes register(CourseRegisterReq courseRegisterReq) {
        CourseRegistrationRes courseRegistrationRes = new CourseRegistrationRes();
        Course course = new Course();
        course.setCourseName(courseRegisterReq.getCourseName());

        try{
//            courseRepo.save(course);
            courseRegistrationRes.setStatusId(0);
            courseRegistrationRes.setStatusDesc("course registered !");
        } catch (Exception e) {
            courseRegistrationRes.setStatusId(-1);
            courseRegistrationRes.setStatusDesc("DB exception !");
            return courseRegistrationRes;
        }
        return courseRegistrationRes;
    }
}
