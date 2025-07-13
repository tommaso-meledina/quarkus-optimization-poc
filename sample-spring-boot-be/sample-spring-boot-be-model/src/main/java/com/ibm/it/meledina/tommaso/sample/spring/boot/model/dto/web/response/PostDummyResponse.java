package com.ibm.it.meledina.tommaso.sample.spring.boot.model.dto.web.response;

import com.ibm.it.meledina.tommaso.sample.spring.boot.model.dto.web.Dummy;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Getter
@AllArgsConstructor
public class PostDummyResponse extends BaseResponse {
  private final Dummy insertedRecord;
}
