package com.example.blogsystem.controller;

import com.example.blogsystem.exception.ApiException;
import com.example.blogsystem.model.Blog;
import com.example.blogsystem.repository.BlogRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/blog")
public class BlogController {


    private final BlogRepository blogRepository;

    @GetMapping
    public ResponseEntity getBlogs(){
        return ResponseEntity.status(200).body(blogRepository.findAll());
    }

    @PostMapping
    public ResponseEntity addBlog(@RequestBody @Valid Blog blog){
        if(blog.getTitle().equals("Class Math")){
            throw new ApiException("Class Math can't be the title");
        }
        blogRepository.save(blog);
        return ResponseEntity.status(200).body("New blog added !");
    }
}
