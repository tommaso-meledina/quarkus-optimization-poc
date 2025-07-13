package com.ibm.it.meledina.tommaso.sample.spring.boot.application.controller;

import com.ibm.it.meledina.tommaso.sample.spring.boot.application.service.DummyService;
import com.ibm.it.meledina.tommaso.sample.spring.boot.model.dto.web.request.PostDummyRequest;
import com.ibm.it.meledina.tommaso.sample.spring.boot.model.dto.web.response.GetDummyResponse;
import com.ibm.it.meledina.tommaso.sample.spring.boot.model.dto.web.response.PostDummyResponse;
import com.ibm.it.meledina.tommaso.sample.spring.boot.model.framework.ApiPaths;
import io.micrometer.core.annotation.Counted;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPaths.DummyController.BASE_PATH)
@RequiredArgsConstructor
public class DummyController {

  private final DummyService dummyService;

  @Counted(
      value = "count_getDummy_invocations_total",
      description = "counts how many times operation GET /dummies is invoked")
  @GetMapping(ApiPaths.Common.EMPTY_PATH)
  public GetDummyResponse getDummy() {
    return dummyService.getDummy();
  }

  @PostMapping(value = ApiPaths.Common.EMPTY_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
  public PostDummyResponse postDummy(@RequestBody PostDummyRequest request) {
    return dummyService.postDummy(request.dummyName());
  }
}
