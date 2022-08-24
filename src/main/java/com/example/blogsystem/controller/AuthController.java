package com.example.blogsystem.controller;

import com.example.blogsystem.dto.RegisterForm;
import com.example.blogsystem.model.AdminBlog;
import com.example.blogsystem.model.User;
import com.example.blogsystem.model.UserBlog;
import com.example.blogsystem.repository.AdminBlogRepository;
import com.example.blogsystem.repository.UserBlogRepository;
import com.example.blogsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final AdminBlogRepository adminBlogRepository;
    private final UserBlogRepository userBlogRepository;


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterForm registerForm){
        String hashedPassword=new BCryptPasswordEncoder().encode(registerForm.getPassword());
        registerForm.setPassword(hashedPassword);
        User user=new User(null,registerForm.getUsername(),registerForm.getPassword(),registerForm.getRole());
        User newUser=userRepository.save(user);
        if(registerForm.getRole().equals("ADMIN")){
            AdminBlog adminBlog=new AdminBlog(null,registerForm.getFullName(),registerForm.getLocation(),newUser.getId());
            adminBlogRepository.save(adminBlog);
        }else {
            UserBlog userBlog=new UserBlog(null,registerForm.getAge(),newUser.getId());
            userBlogRepository.save(userBlog);
        }


        return ResponseEntity.status(201).body("New User registered !");
    }
}
