package com.fundamentosplatzi.springboot.proyectrospring.repository;

import com.fundamentosplatzi.springboot.proyectrospring.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
