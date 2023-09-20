package com.soebes.spring.example.api;

import com.soebes.spring.example.post.PostDTO;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PostController.class)
class PostControllerTest {

  @MockBean
  private PostApiService postApiService;

  @Autowired
  private MockMvc mockMvc;

  @Nested
  class Posts {

    @Test
    void checkForStatus() throws Exception {
      when(postApiService.posts()).thenReturn(ResponseEntity.ok(List.of()));

      mockMvc.perform(get("/api/v1/posts"))
          .andExpect(status().isOk());
    }

    @Test
    void emptyContent() throws Exception {
      when(postApiService.posts()).thenReturn(ResponseEntity.ok(List.of()));

      mockMvc.perform(get("/api/v1/posts"))
          .andExpect(content().json("""
              [
              ]
              """))
          .andExpect(status().is2xxSuccessful());
    }

    @Test
    void singlePost() throws Exception {
      when(postApiService.posts())
          .thenReturn(ResponseEntity.ok(List.of(PostDTO.of(5L, "Post First", "Slug 1"))));

      mockMvc.perform(get("/api/v1/posts"))
          .andExpect(content().json("""
              [{
                "id":5,
                "title":"Post First",
                "slug":"Slug 1"
              }]
              """))
          .andExpect(status().is2xxSuccessful());
    }
  }
}