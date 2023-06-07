package com.example.study.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentScoreDto {
    private Integer id;
    private String name;
    private String type;
    private Integer credit;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date time;
    private Integer score;
    private Double gpa;
    private String status;
}
