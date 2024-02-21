package com.example.practiceapi.controller;

import com.example.practiceapi.pojo.DevoteeEnrollReq;
import com.example.practiceapi.pojo.DevoteeEnrollRes;
import com.example.practiceapi.pojo.DevoteeRegistrationReq;
import com.example.practiceapi.pojo.DevoteeRegistrationRes;
import com.example.practiceapi.services.DevoteeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("devotee")
public class DevoteeController {
    @Autowired
    DevoteeService devoteeService;

    @GetMapping("test")
    private String testDevotee(){
        return "under Krsna !";
    }

    @PostMapping("register")
    private ResponseEntity<DevoteeRegistrationRes> register(@RequestBody @Valid DevoteeRegistrationReq devoteeRegistrationReq){
        DevoteeRegistrationRes devoteeRegistrationRes = devoteeService.register(devoteeRegistrationReq);
        return new ResponseEntity<>(devoteeRegistrationRes, HttpStatus.CREATED);
    }

    @PostMapping("enroll")
    private ResponseEntity<DevoteeEnrollRes> enroll(@RequestBody @Valid DevoteeEnrollReq devoteeEnrollReq){
        DevoteeEnrollRes devoteeEnrollRes = devoteeService.enroll(devoteeEnrollReq);
        return new ResponseEntity<>(devoteeEnrollRes, HttpStatus.CREATED);
    }
}
