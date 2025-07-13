package com.ibm.it.meledina.tommaso.sample.quarkus.application.service;

import com.ibm.it.meledina.tommaso.sample.quarkus.application.mapper.DummyMapper;
import com.ibm.it.meledina.tommaso.sample.quarkus.application.repository.DummyRepository;
import com.ibm.it.meledina.tommaso.sample.quarkus.model.dto.web.Dummy;
import com.ibm.it.meledina.tommaso.sample.quarkus.model.dto.web.response.GetDummyResponse;
import com.ibm.it.meledina.tommaso.sample.quarkus.model.dto.web.response.PostDummyResponse;
import com.ibm.it.meledina.tommaso.sample.quarkus.model.dto.web.response.PutDummyResponse;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class DummyService {
  private final DummyRepository dummyRepository;
  private final DummyMapper dummyMapper;

  public GetDummyResponse getDummies() {
    return new GetDummyResponse(
        dummyRepository.getDummies().stream().map(dummyMapper::dummyToDummyDto).toList());
  }

  public PostDummyResponse addDummy(String dummyName) {
    return new PostDummyResponse(dummyRepository.addDummy(dummyName) ? 1 : 0);
  }

  public PutDummyResponse updateDummy(Dummy dummy) {
    com.ibm.it.meledina.tommaso.sample.quarkus.model.entity.Dummy updatedEntity =
        dummyMapper.dummyDtoToDummy(dummy, dummyRepository);
    return new PutDummyResponse(
        dummyMapper.dummyToDummyDto(dummyRepository.updateDummy(updatedEntity)));
  }
}
