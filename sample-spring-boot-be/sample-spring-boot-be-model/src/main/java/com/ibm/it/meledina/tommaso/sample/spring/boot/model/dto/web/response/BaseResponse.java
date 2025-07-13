package com.ibm.it.meledina.tommaso.sample.spring.boot.model.dto.web.response;

import com.ibm.it.meledina.tommaso.sample.spring.boot.model.dto.web.BaseDto;
import com.ibm.it.meledina.tommaso.sample.spring.boot.model.framework.Messages;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BaseResponse extends BaseDto {
  private final String message;

  public BaseResponse() {
    this.message = Messages.OK;
  }
}
