package com.example.Course.Register.System.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Courses {
    @Id
    private String courseId;
    private String courseName;
    private String trainer;
    private int durationInWeek;
}
