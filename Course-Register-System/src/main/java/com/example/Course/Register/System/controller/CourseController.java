package com.example.Course.Register.System.controller;

import com.example.Course.Register.System.model.CourseRegistry;
import com.example.Course.Register.System.model.Courses;
import com.example.Course.Register.System.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("courses")
    public List<Courses> getAllCourses(){
        return courseService.getAllCourses();
    }


    @PostMapping("/courses/register")
    public String enrollNewCourse(@RequestParam("name") String name,
                                    @RequestParam("emailId") String emailId,
                                    @RequestParam("courseName") String courseName){
        return courseService.enrollNewCourse(name,emailId,courseName);
    }
}
