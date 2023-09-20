package com.soebes.spring.example.post;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ExtendWith(SoftAssertionsExtension.class)
class PostMapperTest {

  @Test
  void mapPostToPostDTO(SoftAssertions soft) {
    var post = new Post();
    post.setId(5L);
    post.setTitle("Post Title");
    post.setSlug("PostSlug");

    assertThat(PostMapper.toDTO.apply(post)).satisfies(dto -> {
      soft.assertThat(dto.id()).isEqualTo(5L);
      soft.assertThat(dto.title()).isEqualTo("Post Title");
      soft.assertThat(dto.slug()).isEqualTo("PostSlug");
    });
  }
}