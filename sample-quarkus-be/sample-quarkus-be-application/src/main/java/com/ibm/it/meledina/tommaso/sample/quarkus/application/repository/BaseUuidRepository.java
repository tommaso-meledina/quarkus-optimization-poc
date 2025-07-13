package com.ibm.it.meledina.tommaso.sample.quarkus.application.repository;

import com.ibm.it.meledina.tommaso.sample.quarkus.model.entity.BaseEntity;
import com.ibm.it.meledina.tommaso.sample.quarkus.model.entity.BaseUuidEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.Optional;

public abstract class BaseUuidRepository<T extends BaseUuidEntity> implements PanacheRepository<T> {

  public Optional<T> findByUuid(String uuid) {
    return find("uuid", uuid).stream().findFirst();
  }

  public Long findIdByUuid(String uuid) {
    return find("uuid", uuid).stream().findFirst().map(BaseEntity::getId).orElse(null);
  }
}
