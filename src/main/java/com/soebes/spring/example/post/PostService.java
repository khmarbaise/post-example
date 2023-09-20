package com.soebes.spring.example.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.history.Revision;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.soebes.spring.example.post.PostMapper.toDTO;


@Service
public class PostService {

  private static final Logger LOG = LoggerFactory.getLogger(PostService.class);

  private final PostRepository postRepository;


  PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public List<PostDTO> posts() {
    return postRepository.findAll().stream().map(toDTO).toList();
  }

  public List<Revision<Long, PostDTO>> versions(Long id) {
    var revisions = postRepository.findRevisions(id);
    return revisions.getContent().stream().map(r -> {
      LOG.info("revision: {}", r.getRevisionNumber());
      return Revision.of(r.getMetadata(), PostMapper.toDTO.apply(r.getEntity()));
    }).toList();
  }

  @EventListener
  void ready(ApplicationReadyEvent event) {
    LOG.info("ApplicationReadyEvent received. start {}", event.getTimeTaken());
    postRepository.findAll().parallelStream().forEach(
        s -> LOG.info("Post: id: {} title: {} slug: {}", s.getId(), s.getTitle(), s.getSlug())
    );
    LOG.info("ApplicationReadyEvent received. end.");
  }

}
