package com.ibm.it.meledina.tommaso.sample.spring.boot.application.repository;

import com.ibm.it.meledina.tommaso.sample.spring.boot.model.entity.BaseUuidEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseUuidRepository<T extends BaseUuidEntity> extends JpaRepository<T, Long> {
  Optional<T> findByUuid(String uuid);

  Optional<Long> findIdByUuid(String uuid);
}
