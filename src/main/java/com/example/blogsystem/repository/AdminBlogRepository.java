package com.example.blogsystem.repository;

import com.example.blogsystem.model.AdminBlog;
import com.example.blogsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminBlogRepository extends JpaRepository<AdminBlog,Integer> {


}
