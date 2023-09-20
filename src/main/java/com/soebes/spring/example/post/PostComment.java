package com.soebes.spring.example.post;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;
import org.hibernate.envers.Audited;

@Entity
@Audited
class PostComment extends AbstractEntity {

  private String review;

  @Version
  private Long version;

  @ManyToOne(fetch = FetchType.LAZY)
  private Post post;

  protected PostComment() {
  }

  PostComment(Long id, String review, Post post) {
    setId(id);
    this.review = review;
    this.post = post;
    this.version = 0L;
  }

  void setVersion(Long version) {
    this.version = version;
  }

  Long getVersion() {
    return version;
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
