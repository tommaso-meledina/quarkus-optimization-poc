package com.ibm.it.meledina.tommaso.sample.spring.boot.application.service;

import com.ibm.it.meledina.tommaso.sample.spring.boot.application.mapper.DummyMapper;
import com.ibm.it.meledina.tommaso.sample.spring.boot.application.repository.DummyRepository;
import com.ibm.it.meledina.tommaso.sample.spring.boot.model.dto.web.Dummy;
import com.ibm.it.meledina.tommaso.sample.spring.boot.model.dto.web.response.GetDummyResponse;
import com.ibm.it.meledina.tommaso.sample.spring.boot.model.dto.web.response.PostDummyResponse;
import io.micrometer.core.annotation.Counted;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DummyService {

  private final DummyRepository dummyRepository;
  private final DummyMapper dummyMapper;

  public GetDummyResponse getDummy() {
    return new GetDummyResponse(
        dummyRepository.findAll().stream()
            .map(dummyMapper::dummyToDummyDto)
            .toList()
    );
  }

  public PostDummyResponse postDummy(String dummyName) {

    final com.ibm.it.meledina.tommaso.sample.spring.boot.model.entity.Dummy insertedDummy =
        dummyRepository.save(
            new com.ibm.it.meledina.tommaso.sample.spring.boot.model.entity.Dummy(dummyName));

    return new PostDummyResponse(
        new Dummy(
            insertedDummy.getUuid(),
            insertedDummy.getName()
        )
    );
  }
}
