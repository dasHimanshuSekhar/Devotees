package com.example.practiceapi.services;

import com.example.practiceapi.pojo.DevoteeEnrollReq;
import com.example.practiceapi.pojo.DevoteeEnrollRes;
import com.example.practiceapi.pojo.DevoteeRegistrationReq;
import com.example.practiceapi.pojo.DevoteeRegistrationRes;

public interface DevoteeService {
    DevoteeRegistrationRes register(DevoteeRegistrationReq devoteeRegistrationReq);

    DevoteeEnrollRes enroll(DevoteeEnrollReq devoteeEnrollReq);
}
