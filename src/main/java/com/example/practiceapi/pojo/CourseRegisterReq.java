package com.example.practiceapi.pojo;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class CourseRegisterReq {
    @NotNull(message = "course name mandatory !")
    private String courseName;
}
