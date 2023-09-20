package com.soebes.spring.example.post;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "post_comment")
class PostComment {

  @Id
  @GeneratedValue
  private Long id;

  private String review;

  @ManyToOne(fetch = FetchType.LAZY)
  private Post post;

  protected PostComment() {
  }

  PostComment(Long id, String review, Post post) {
    this.id = id;
    this.review = review;
    this.post = post;
  }

  Long getId() {
    return id;
  }

  void setId(Long id) {
    this.id = id;
  }

  String getReview() {
    return review;
  }

  void setReview(String review) {
    this.review = review;
  }

  Post getPost() {
    return post;
  }

  void setPost(Post post) {
    this.post = post;
  }
}
