package com.soebes.spring.example.post;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "post")
class Post {

  @Id
  private Long id;

  private String title;

  @NaturalId
  private String slug;

  protected Post() {
  }

  Long getId() {
    return id;
  }

  Post(Long id, String title, String slug) {
    this.id = id;
    this.title = title;
    this.slug = slug;
  }

  void setId(Long id) {
    this.id = id;
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