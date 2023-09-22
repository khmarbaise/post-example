package com.soebes.spring.example.post;

import jakarta.persistence.Entity;
import org.hibernate.annotations.NaturalId;
import org.hibernate.envers.Audited;

@Entity
@Audited
class Post extends AbstractEntity {

  private String title;

  @NaturalId
  private String slug;

  protected Post() {
  }

  Post(String title, String slug) {
    super(0L);
    this.title = title;
    this.slug = slug;
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