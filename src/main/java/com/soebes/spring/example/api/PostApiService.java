package com.soebes.spring.example.api;

import com.soebes.spring.example.post.PostDTO;
import com.soebes.spring.example.post.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class PostApiService {


  private final PostService postService;

  PostApiService(PostService postService) {
    this.postService = postService;
  }

  ResponseEntity<List<PostDTO>> posts() {
    return ResponseEntity.ok(postService.posts());
  }
}
