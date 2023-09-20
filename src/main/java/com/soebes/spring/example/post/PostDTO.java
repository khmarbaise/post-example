package com.soebes.spring.example.post;

public record PostDTO(Long id, String title, String slug, Long version) {
  public static PostDTO of(Long id, String title, String slug, Long version) {
    return new PostDTO(id, title, slug, version);
  }
}
