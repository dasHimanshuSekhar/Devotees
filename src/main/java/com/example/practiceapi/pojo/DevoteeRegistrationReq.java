package com.example.practiceapi.pojo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DevoteeRegistrationReq {
    @NotNull(message = "devotee user name is mandatory !")
    private String devoteeUserName;
    @NotNull(message = "devotee name is mandatory !")
    private String devoteeName;
    @Size(min = 5, max = 70)
    private int age;

}
