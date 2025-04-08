package com.example.Course.Register.System.service;

import com.example.Course.Register.System.model.CourseRegistry;
import com.example.Course.Register.System.model.Courses;
import com.example.Course.Register.System.repository.CourseRegistryRepo;
import com.example.Course.Register.System.repository.CoursesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CoursesRepo coursesRepo;

    @Autowired
    CourseRegistryRepo courseRegistryRepo;

    public List<Courses> getAllCourses() {
        return coursesRepo.findAll();
    }

    public List<CourseRegistry> getEnrolledStudents() {
        return courseRegistryRepo.findAll();
    }

    public String enrollNewCourse(String name, String emailId, String courseName) {
        CourseRegistry courseRegistry = new CourseRegistry(name,emailId,courseName);
        courseRegistryRepo.save(courseRegistry);
        return "Congratulations "+name+" ,Your new Course "+courseName+ " is Successfully Enrolled";
    }
}
