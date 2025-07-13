package com.ibm.it.meledina.tommaso.sample.quarkus.model.entity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class BaseUuidEntity extends BaseEntity {
  @NotNull private String uuid;

  protected BaseUuidEntity(Long id, String uuid) {
    super(id);
    this.uuid = uuid;
  }

  @PrePersist
  @SuppressFBWarnings({"UPM_UNCALLED_PRIVATE_METHOD"})
  private void generateUuid() {
    this.uuid = UUID.randomUUID().toString();
  }
}
