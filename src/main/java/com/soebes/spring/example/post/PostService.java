package com.soebes.spring.example.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;


@Service
public class PostService {

  private static final Logger LOG = LoggerFactory.getLogger(PostService.class);

  private final PostRepository postRepository;

  PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @EventListener
  void ready(ApplicationReadyEvent event) {
    LOG.info("ApplicationReadyEvent received. start {}", event.getTimeTaken());
    postRepository.findAll().parallelStream().forEach(
        s -> LOG.info(" id: {} title: {} slug: {}", s.getId(), s.getTitle(), s.getSlug())
    );
    LOG.info("ApplicationReadyEvent received. end.");
  }


}
