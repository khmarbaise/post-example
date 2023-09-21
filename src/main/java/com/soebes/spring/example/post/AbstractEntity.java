package com.soebes.spring.example.post;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import jakarta.persistence.Version;
import org.springframework.data.util.ProxyUtils;

import static java.util.Objects.isNull;

/**
 * @author Oliver Gierke
 * @author Thomas Darimont
 * @author Mark Paluch
 * @author Greg Turnquist
 * @implNote A lot of code has been taken from the {@link org.springframework.data.jpa.domain.AbstractPersistable} class.
 * The reason for that was that attributes, methods etc. defined as {@code public}. In the example
 * project I don't want to define anything {@code public} which is not absolutely necessary.
 * The original authors of the {@link org.springframework.data.jpa.domain.AbstractPersistable} classes are listed
 * here as well.
 */
@MappedSuperclass
abstract class AbstractEntity {

  @Id
  @GeneratedValue
  private Long id;

  @Version
  private Long version;

  protected AbstractEntity() {
  }

  AbstractEntity(Long id, Long version) {
    this.id = id;
    this.version = version;
  }

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
   * @return the version.
   */
  Long getVersion() {
    return version;
  }

  /**
   * @param version The version to be used.
   */
  void setVersion(Long version) {
    this.version = version;
  }

  /**
   * Must be {@link Transient} in order to ensure that no JPA provider complains because of a missing setter.
   */
  @Transient
  boolean isNew() {
    return isNull(getId());
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
