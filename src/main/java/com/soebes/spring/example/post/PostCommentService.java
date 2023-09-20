package com.soebes.spring.example.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class PostCommentService {

  private static final Logger LOG = LoggerFactory.getLogger(PostCommentService.class);

  private final PostRepository postRepository;

  private final PostCommentRepository postCommentRepository;

  PostCommentService(PostRepository postRepository, PostCommentRepository postCommentRepository) {
    this.postRepository = postRepository;
    this.postCommentRepository = postCommentRepository;
  }

  public PostCommentDTO addNewComment(String review, Long postId) {
    var postComment = new PostComment();
    postComment.setReview(review);
    postComment.setPost(postRepository.getReferenceById(postId));
    postCommentRepository.save(postComment);
    return PostCommentMapper.toDTO.apply(postComment);
  }


  @EventListener
  void ready(ApplicationReadyEvent event) {
    LOG.info("ApplicationReadyEvent received. start {}", event.getTimeTaken());
    postCommentRepository.findAll().parallelStream().forEach(
        s -> LOG.info("Review: id: {} review: {}", s.getId(), s.getReview())
    );
    LOG.info("ApplicationReadyEvent received. end.");
  }


}
