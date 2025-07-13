package com.ibm.it.meledina.tommaso.sample.quarkus.model.dto.web;

import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = true)
public class BaseUuidDto extends BaseDto {
  @NotNull private final String uuid;

  public BaseUuidDto(String uuid) {
    this.uuid = uuid;
  }
}
