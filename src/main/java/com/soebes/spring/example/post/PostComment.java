package com.soebes.spring.example.post;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import org.hibernate.envers.Audited;

@Entity
@Audited
class PostComment extends AbstractEntity {

  private String review;

  @ManyToOne(fetch = FetchType.LAZY)
  private Post post;

  protected PostComment() {
  }

  PostComment(Long id, String review, Post post) {
    super(id, 0L);
    this.review = review;
    this.post = post;
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
