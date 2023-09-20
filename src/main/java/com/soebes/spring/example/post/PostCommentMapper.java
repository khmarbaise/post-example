package com.soebes.spring.example.post;

import java.util.function.Function;

final class PostCommentMapper {
  private PostCommentMapper() {
  }

  static Function<PostComment, PostCommentDTO> toDTO = postComment -> new PostCommentDTO(
      postComment.getId(),
      postComment.getReview(),
      PostMapper.toDTO.apply(postComment.getPost())
  );

}
