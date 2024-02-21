package com.example.practiceapi.pojo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Data
public class DevoteeEnrollReq {
    @NotNull(message = "devotee user name is mandatory !")
    private String devoteeUserName;
    @NotNull(message = "at least one course mandatory !")
    private Set<String> courseName;
}
