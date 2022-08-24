package com.example.blogsystem.repository;

import com.example.blogsystem.model.UserBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBlogRepository extends JpaRepository<UserBlog,Integer> {


}
