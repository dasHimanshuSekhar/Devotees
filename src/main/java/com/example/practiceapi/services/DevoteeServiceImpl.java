package com.example.practiceapi.services;

import com.example.practiceapi.entity.Course;
import com.example.practiceapi.entity.Devotee;
import com.example.practiceapi.pojo.DevoteeEnrollReq;
import com.example.practiceapi.pojo.DevoteeEnrollRes;
import com.example.practiceapi.pojo.DevoteeRegistrationReq;
import com.example.practiceapi.pojo.DevoteeRegistrationRes;
import com.example.practiceapi.repository.CourseRepo;
import com.example.practiceapi.repository.DevoteeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class DevoteeServiceImpl implements DevoteeService{
    @Autowired
    private DevoteeRepo devoteeRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public DevoteeRegistrationRes register(DevoteeRegistrationReq devoteeRegistrationReq) {

        DevoteeRegistrationRes devoteeRegistrationRes = new DevoteeRegistrationRes();
        Devotee devotee = new Devotee();

        //Internal Validation
        Boolean devoteeExistence;
        try {
            devoteeExistence = devoteeRepo.existsByDevoteeUserName(devoteeRegistrationReq.getDevoteeUserName());
            if(devoteeExistence){
                devoteeRegistrationRes.setStatusId(-1);
                devoteeRegistrationRes.setStatusDesc("user name exist, Kindly provide unique !");
                return devoteeRegistrationRes;
            }
        } catch (Exception e) {
            devoteeRegistrationRes.setStatusId(-1);
            devoteeRegistrationRes.setStatusDesc("Exception Occurred !");
            return devoteeRegistrationRes;
        }


        devotee.setDevoteeUserName(devoteeRegistrationReq.getDevoteeUserName());
        devotee.setDevoteeName(devoteeRegistrationReq.getDevoteeName());
        devotee.setAge(devoteeRegistrationReq.getAge());


        try {
//            devoteeRepo.save(devotee);
            devoteeRegistrationRes.setStatusId(0);
            devoteeRegistrationRes.setStatusDesc("devotee registered !");
        } catch (Exception e) {
            devoteeRegistrationRes.setStatusId(-1);
            devoteeRegistrationRes.setStatusDesc("DB Exception !");
            return devoteeRegistrationRes;
        }

        return devoteeRegistrationRes;
    }

    @Override
    public DevoteeEnrollRes enroll(DevoteeEnrollReq devoteeEnrollReq) {
        DevoteeEnrollRes devoteeEnrollRes = new DevoteeEnrollRes();

        //fetch Devotee
        try{
            Optional<Devotee> devoteeOptional = devoteeRepo.findByDevoteeUserName(devoteeEnrollReq.getDevoteeUserName());
            if(devoteeOptional.isEmpty()){
                devoteeEnrollRes.setStatusId(-1);
                devoteeEnrollRes.setStatusDesc("user doesn't exist !");
                return devoteeEnrollRes;
            }
        } catch (Exception e) {
            devoteeEnrollRes.setStatusId(-1);
            devoteeEnrollRes.setStatusDesc("DB Exception !");
            return devoteeEnrollRes;
        }

        //fetch Course
        /*
        * OPTION 1:
        *
        * fetch courses {courseName, courseId} as => HashMap
        * fetch course_list request as => List
        * Iterate over reqList and check existence w.r.t. HashMap
        *
        * OPTION 2:
        * cache store technique so that no need to fetch all the time.
        * ### PROBLEM: Need to update the cache w.r.t. course table
        * ### ADVANTAGE: Fast retrieval of data
        * */

        return null;
    }
}
