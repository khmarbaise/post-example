package com.soebes.spring.example;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.core.DependencyDepth;
import org.springframework.modulith.docs.Documenter;
import org.springframework.modulith.docs.Documenter.DiagramOptions;

import static org.springframework.modulith.core.DependencyType.ENTITY;
import static org.springframework.modulith.core.DependencyType.EVENT_LISTENER;
import static org.springframework.modulith.core.DependencyType.USES_COMPONENT;
import static org.springframework.modulith.docs.Documenter.DiagramOptions.DiagramStyle.C4;

class DocumentationIT {

  private final ApplicationModules modules = ApplicationModules.of(PostAndPostCommentApplication.class);

  @Test
  @SuppressWarnings("java:S2699") //Tests should include assertions
  void writeDocumentationSnippets() {

    modules.forEach(System.out::println);
    var diagramOptions = DiagramOptions.defaults()
        .withDependencyDepth(DependencyDepth.ALL)
        .withDependencyTypes(USES_COMPONENT, ENTITY, EVENT_LISTENER)
        .withStyle(C4);
    var canvasOptions = Documenter.CanvasOptions.defaults();

    new Documenter(modules)
        .writeModuleCanvases()
        .writeModulesAsPlantUml()
        .writeIndividualModulesAsPlantUml()
        .writeDocumentation(diagramOptions, canvasOptions);
  }
}
