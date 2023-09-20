package com.soebes.spring.example.post;

public record PostDTO(Long id, String title, String slug) {
  public static PostDTO of(Long id, String title, String slug) {
    return new PostDTO(id, title, slug);
  }
}
