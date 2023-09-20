
package com.soebes.spring.example.api;

import com.soebes.spring.example.post.PostDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
final class PostController {

  private final PostApiService postApiService;

  PostController(PostApiService postApiService) {
    this.postApiService = postApiService;
  }

  @GetMapping("/posts")
  ResponseEntity<List<PostDTO>> findAll() {
    return postApiService.posts();
  }
}
