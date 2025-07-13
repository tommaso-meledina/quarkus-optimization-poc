package com.ibm.it.meledina.tommaso.sample.spring.boot.model.dto.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Getter
public class Dummy extends BaseUuidDto {
  @NotNull(message = "Bro...")
  @NotBlank(message = "BRO..!")
  private final String name;

  public Dummy(String uuid, String name) {
    super(uuid);
    this.name = name;
  }
}
