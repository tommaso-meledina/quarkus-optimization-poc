package com.ibm.it.meledina.tommaso.sample.quarkus.model.dto.web.request;

import com.ibm.it.meledina.tommaso.sample.quarkus.model.dto.web.Dummy;
import jakarta.validation.Valid;

public record PutDummyRequest(@Valid Dummy dummy) {}
