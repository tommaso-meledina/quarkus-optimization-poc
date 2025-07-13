package com.ibm.it.meledina.tommaso.sample.spring.boot.model.dto.web.response;

import com.ibm.it.meledina.tommaso.sample.spring.boot.model.dto.web.Dummy;
import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class PutDummyResponse extends BaseResponse {
  Dummy updatedRecord;
}
