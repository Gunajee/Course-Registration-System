package com.example.Course.Register.System.repository;

import com.example.Course.Register.System.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepo extends JpaRepository<Courses,String> {
}
