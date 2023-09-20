package com.soebes.spring.example.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

interface PostCommentRepository extends JpaRepository<PostComment, Long>, RevisionRepository<PostComment, Long, Long> {
}
