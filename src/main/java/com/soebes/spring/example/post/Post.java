package com.soebes.spring.example.post;

import jakarta.persistence.Entity;
import jakarta.persistence.Version;
import org.hibernate.annotations.NaturalId;
import org.hibernate.envers.Audited;

@Entity
@Audited
class Post extends AbstractEntity {

  private String title;

  @NaturalId
  private String slug;

  @Version
  private Long version;

  protected Post() {
  }

  Post(Long id, String title, String slug) {
    setId(id);
    this.title = title;
    this.slug = slug;
    this.version = 0L;
  }

  Long getVersion() {
    return version;
  }

  void setVersion(Long version) {
    this.version = version;
  }

  String getTitle() {
    return title;
  }

  void setTitle(String title) {
    this.title = title;
  }

  String getSlug() {
    return slug;
  }

  void setSlug(String slug) {
    this.slug = slug;
  }
}