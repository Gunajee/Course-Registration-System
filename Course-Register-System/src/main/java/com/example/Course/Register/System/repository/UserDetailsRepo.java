package com.example.Course.Register.System.repository;

import com.example.Course.Register.System.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends JpaRepository<Users,Integer> {
    Users getByUsername(String username);
}
