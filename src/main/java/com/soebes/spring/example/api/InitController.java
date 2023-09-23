
package com.soebes.spring.example.api;

import com.soebes.spring.example.post.InitializeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("/api/v1")
@RestController
final class InitController {

  private final InitializeService initializeService;

  InitController(InitializeService initializeService) {
    this.initializeService = initializeService;
  }

  @GetMapping(value = "/initialize", produces = {APPLICATION_JSON_VALUE})
  ResponseEntity<Boolean> initialize() {
    initializeService.initialize();
    return ResponseEntity.ok(Boolean.TRUE);
  }

}
