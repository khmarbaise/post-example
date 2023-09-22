package com.soebes.spring.example.post;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
class DataLoader {

  private final PostRepository postRepository;
  private final PostCommentRepository postCommentRepository;

  private static final Logger LOG = LogManager.getLogger(DataLoader.class);

  DataLoader(PostRepository postRepository, PostCommentRepository postCommentRepository) {
    this.postRepository = postRepository;
    this.postCommentRepository = postCommentRepository;
  }

  @EventListener(ApplicationReadyEvent.class)
  void loadData(ApplicationReadyEvent event) {
    LOG.info("ApplicationReadyEvent received. start {}", event.getTimeTaken());
    LOG.info("loadData started. (before lambda)");
    LOG.info("Inside Lambda started.");

    var post1 = new Post("First Post", "First slug");
    var savePost1 = postRepository.save(post1);
    savePost1.setTitle("First Post (R2)");
    var savePost1R2 = postRepository.save(savePost1);

    savePost1R2.setTitle("First Post (R3)");
    var savePost1R3 = postRepository.save(savePost1R2);

    var savedPostComment1 = postCommentRepository.save(new PostComment("Review 1 / 1", savePost1R3));

    savedPostComment1.setReview("Review 1 / 1 (R2)");
    postCommentRepository.save(savedPostComment1);

    postCommentRepository.save(new PostComment("Review 2 / 1", savePost1R3));

    var post2 = new Post("Second Post", "Second slug");
    var savedPost2 = postRepository.save(post2);

    postCommentRepository.save(new PostComment("Review 1 / 2", savedPost2));
    postCommentRepository.save(new PostComment("Review 2 / 2", savedPost2));
    postCommentRepository.save(new PostComment("Review 3 / 2", savedPost2));

    var post3 = new Post("Third Post", "Third slug");
    var savedPost3 = postRepository.save(post3);

    postCommentRepository.save(new PostComment("Review 1 / 3", savedPost3));

    LOG.info("loadData done.");
  }
}
