package com.ibm.it.meledina.tommaso.sample.quarkus.application.mapper;

import com.ibm.it.meledina.tommaso.sample.quarkus.application.repository.DummyRepository;
import com.ibm.it.meledina.tommaso.sample.quarkus.model.dto.web.Dummy;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "cdi")
public interface DummyMapper {
  DummyMapper INSTANCE = Mappers.getMapper(DummyMapper.class);

  Dummy dummyToDummyDto(com.ibm.it.meledina.tommaso.sample.quarkus.model.entity.Dummy dummyEntity);

  default com.ibm.it.meledina.tommaso.sample.quarkus.model.entity.Dummy dummyDtoToDummy(
      Dummy dummy, @Context DummyRepository dummyRepository) {
    Long id = dummyRepository.findIdByUuid(dummy.getUuid());
    return id != null
        ? new com.ibm.it.meledina.tommaso.sample.quarkus.model.entity.Dummy(id, dummy.getUuid(),
        dummy.getName())
        : null;
  }
}
