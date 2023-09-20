package com.soebes.spring.example.post;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "post")
class Post extends AbstractEntity {

  private String title;

  @NaturalId
  private String slug;

  protected Post() {
  }

  Post(Long id, String title, String slug) {
    setId(id);
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