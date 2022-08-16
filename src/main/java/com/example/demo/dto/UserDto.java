package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto implements Serializable {
    @NotEmpty(message = "Email can't be empty")
    private  String email;
    @NotEmpty(message = "company name cant be empty")
    private  String companyname;
    @Min(value = 0,message = "minimim experiance is 0")
    private  Integer yoe;
    @NotEmpty(message = "Job role cant be empty")
    private  String title;
    @NotEmpty(message = "CTC cant be empty")
    private  String ctc;
    @NotEmpty(message = "base cant be empty")
    private  String base;
    @NotEmpty(message = "City Name cant be empty")
    private  String cityname;

    @NotEmpty(message = "WLB cant be empty")
    private String wlb;
    @NotEmpty(message = "Interview Question cant be empty")
    private String question;
}
