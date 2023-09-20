package com.soebes.spring.example.post;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import org.springframework.data.util.ProxyUtils;

@MappedSuperclass
abstract class AbstractEntity {

  @Id
  @GeneratedValue
  private Long id;

  Long getId() {
    return id;
  }

  /**
   * Sets the id of the entity.
   *
   * @param id the id to set
   */
  void setId(Long id) {
    this.id = id;
  }

  /**
   * Must be {@link Transient} in order to ensure that no JPA provider complains because of a missing setter.
   *
   */
  @Transient // DATAJPA-622
  boolean isNew() {
    return null == getId();
  }

  @Override
  public boolean equals(Object obj) {

    if (null == obj) {
      return false;
    }

    if (this == obj) {
      return true;
    }

    if (!getClass().equals(ProxyUtils.getUserClass(obj))) {
      return false;
    }

    var that = (AbstractEntity) obj;

    return null != this.getId() && this.getId().equals(that.getId());
  }

  @Override
  public int hashCode() {

    int hashCode = 17;

    hashCode += null == getId() ? 0 : getId().hashCode() * 31;

    return hashCode;
  }
}
