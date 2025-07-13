package com.ibm.it.meledina.tommaso.sample.quarkus.model.dto.web.response;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Getter
@AllArgsConstructor
public class PostDummyResponse extends BaseResponse {
  private final int insertedRecords;
}
