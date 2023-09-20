
package com.soebes.spring.example.api;

import com.soebes.spring.example.post.PostDTO;
import org.springframework.data.history.Revision;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RequestMapping("/api/v1")
@RestController
final class PostController {

  private final PostApiService postApiService;

  PostController(PostApiService postApiService) {
    this.postApiService = postApiService;
  }

  @GetMapping(value = "/posts", produces = {APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE})
  ResponseEntity<List<PostDTO>> findAll() {
    return postApiService.posts();
  }

  @GetMapping(value = "/post/versions/{id}", produces = {APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE})
  ResponseEntity<List<Revision<Long, PostDTO>>> postVersions(@PathVariable String id) {
    return postApiService.revisions(Long.valueOf(id));
  }

}
