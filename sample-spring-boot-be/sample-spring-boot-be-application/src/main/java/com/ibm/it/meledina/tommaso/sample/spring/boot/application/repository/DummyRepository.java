package com.ibm.it.meledina.tommaso.sample.spring.boot.application.repository;

import com.ibm.it.meledina.tommaso.sample.spring.boot.model.entity.Dummy;
import org.springframework.stereotype.Component;

@Component
public interface DummyRepository extends BaseUuidRepository<Dummy> {
}
