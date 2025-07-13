package com.ibm.it.meledina.tommaso.sample.spring.boot.application.mapper;

import com.ibm.it.meledina.tommaso.sample.spring.boot.application.repository.DummyRepository;
import com.ibm.it.meledina.tommaso.sample.spring.boot.model.dto.web.Dummy;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DummyMapper {
  DummyMapper INSTANCE = Mappers.getMapper(DummyMapper.class);

  Dummy dummyToDummyDto(com.ibm.it.meledina.tommaso.sample.spring.boot.model.entity.Dummy dummyEntity);

  default com.ibm.it.meledina.tommaso.sample.spring.boot.model.entity.Dummy dummyDtoToDummy(
      Dummy dummy, @Context DummyRepository dummyRepository) {
    Long id = dummyRepository.findIdByUuid(dummy.getUuid()).orElse(null);
    return id != null
        ? new com.ibm.it.meledina.tommaso.sample.spring.boot.model.entity.Dummy(id, dummy.getUuid(),
        dummy.getName())
        : null;
  }
}
