package com.soebes.spring.example.post;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
record DataLoader() {

  private static final Logger LOG = LogManager.getLogger(DataLoader.class);

  @Bean
  CommandLineRunner loadData(PostRepository postRepository, PostCommentRepository postCommentRepository) {
    LOG.info("loadData started. (before lambda)");
    return args -> {
      LOG.info("Inside Lambda started.");

      var post_1 = new Post(5L, "First Post", "First slug");
      postRepository.save(post_1);

      postCommentRepository.save(new PostComment(10L, "Review 1 / 1", post_1));
      postCommentRepository.save(new PostComment(11L, "Review 2 / 1", post_1));

      var post_2 = new Post(7L, "Second Post", "Second slug");
      postRepository.save(post_2);

      postCommentRepository.save(new PostComment(20L, "Review 1 / 2", post_2));
      postCommentRepository.save(new PostComment(21L, "Review 2 / 2", post_2));
      postCommentRepository.save(new PostComment(22L, "Review 3 / 2", post_2));

      var post_3 = new Post(12L, "Third Post", "Third slug");
      postRepository.save(post_3);

      postCommentRepository.save(new PostComment(30L, "Review 1 / 3", post_3));

      LOG.info("loadData done.");
    };
  }
}
