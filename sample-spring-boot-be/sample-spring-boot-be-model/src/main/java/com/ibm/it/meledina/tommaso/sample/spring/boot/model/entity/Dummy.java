package com.ibm.it.meledina.tommaso.sample.spring.boot.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "DUMMY")
@Data
@NoArgsConstructor
public class Dummy extends BaseUuidEntity {
  @NotNull
  private String name;

  public Dummy(Long id, String uuid, String name) {
    super(id, uuid);
    this.name = name;
  }

  public Dummy(String name) {
    super();
    this.name = name;
  }
}
