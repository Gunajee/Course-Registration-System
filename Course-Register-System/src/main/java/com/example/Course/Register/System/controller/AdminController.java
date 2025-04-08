package com.example.Course.Register.System.controller;

import com.example.Course.Register.System.model.CourseRegistry;
import com.example.Course.Register.System.model.Users;
import com.example.Course.Register.System.service.CourseService;
import com.example.Course.Register.System.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    CourseService courseService;

    @Autowired
    UsersService usersService;

    @GetMapping("/courses/enrolled")
    public List<CourseRegistry> getEnrolledStudents(){
        return courseService.getEnrolledStudents();
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody Users users){
        return usersService.addUser(users);
    }
}
