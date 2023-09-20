package com.soebes.spring.example.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

interface PostRepository extends JpaRepository<Post, Long>, RevisionRepository<Post, Long, Long> {
}
