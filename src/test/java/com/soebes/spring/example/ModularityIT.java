package com.soebes.spring.example;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

class ModularityIT {

  private ApplicationModules modules = ApplicationModules.of(PostAndPostCommentApplication.class);

  @Test
  void verifyModularity() {
    System.out.println("modules = " + modules);

    modules.verify();

  }
}
