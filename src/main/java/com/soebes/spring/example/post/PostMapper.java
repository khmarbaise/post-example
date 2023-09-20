package com.soebes.spring.example.post;

import java.util.function.Function;

final class PostMapper {
  private PostMapper() {
  }

  static Function<Post, PostDTO> toDTO = post -> new PostDTO(
      post.getId(),
      post.getTitle(),
      post.getSlug(),
      post.getVersion()
  );


}
