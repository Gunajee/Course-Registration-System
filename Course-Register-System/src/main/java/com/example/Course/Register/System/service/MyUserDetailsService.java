package com.example.Course.Register.System.service;

import com.example.Course.Register.System.model.UserPrincipal;
import com.example.Course.Register.System.model.Users;
import com.example.Course.Register.System.repository.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserDetailsRepo userDetailsRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userDetailsRepo.getByUsername(username);
        if(users == null){
            throw new UsernameNotFoundException("User not found!");
        }
        return new UserPrincipal(users);
    }
}
