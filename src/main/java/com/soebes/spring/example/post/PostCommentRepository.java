package com.soebes.spring.example.post;

import org.springframework.data.jpa.repository.JpaRepository;

interface PostCommentRepository extends JpaRepository<PostComment, Long> {
}
