package com.ibm.it.meledina.tommaso.sample.spring.boot.model.dto.web.request;

import com.ibm.it.meledina.tommaso.sample.spring.boot.model.dto.web.Dummy;
import jakarta.validation.Valid;

public record PutDummyRequest(@Valid Dummy dummy) {
}
