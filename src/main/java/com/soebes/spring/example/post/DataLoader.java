package com.soebes.spring.example.post;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
record DataLoader() {

  private static final Logger LOG = LogManager.getLogger(DataLoader.class);

  @Bean
  CommandLineRunner loadData(PostRepository repository) {
    LOG.info("loadData started. (before lambda)");
    return args -> {
      LOG.info("Inside Lambda started.");
      var random = new Random();

      repository.save(new Post(random.nextLong(), "First Post", "First slug"));
      repository.save(new Post(random.nextLong(), "Second Post", "Second slug"));
      repository.save(new Post(random.nextLong(), "Third Post", "Third slug"));
      LOG.info("loadData done.");
    };
  }
}
