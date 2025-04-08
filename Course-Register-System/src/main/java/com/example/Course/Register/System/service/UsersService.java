package com.example.Course.Register.System.service;

import com.example.Course.Register.System.model.Users;
import com.example.Course.Register.System.repository.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    UserDetailsRepo userDetailsRepo;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);


    public String addUser(Users users) {
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        userDetailsRepo.save(users);
        return "New User Added Successfully!";
    }
}
