package com.ibm.it.meledina.tommaso.sample.spring.boot.application.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.ibm.it.meledina.tommaso.sample.spring.boot.application.service.DummyService;
import com.ibm.it.meledina.tommaso.sample.spring.boot.model.dto.web.Dummy;
import com.ibm.it.meledina.tommaso.sample.spring.boot.model.dto.web.request.PostDummyRequest;
import com.ibm.it.meledina.tommaso.sample.spring.boot.model.dto.web.response.PostDummyResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@DisplayName("The /dummy resource controller")
@SpringBootTest(classes = DummyController.class)
class DummyControllerTest {

  @Autowired
  private DummyController dummyController;

  @MockitoBean
  private DummyService dummyService;

  @Test
  @DisplayName("when initialized, it should load correctly")
  void initialization_instanceIsNotNull() {
    assertNotNull(dummyController);
  }

//  @Test
//  @DisplayName("when executing getDummy, it should relay the result of DummyService.getDummy")
//  void getDummy() {
//    final GetDummyResponse getDummyResponse = new GetDummyResponse(List.of(new Dummy("abc", 123)));
//    Mockito.when(
//        dummyService.getDummy()
//    ).thenReturn(
//        getDummyResponse
//    );
//
//    assertEquals(
//        getDummyResponse,
//        dummyController.getDummy()
//    );
//  }

  @Test
  @DisplayName("when executing postDummy, it should relay the result of DummyService.postDummy")
  void postDummy() {
    final String dummyName = "some name";
    final String someUuid = "abcd-1234-defg-5678";
    final PostDummyRequest postDummyRequest = new PostDummyRequest(dummyName);
    final PostDummyResponse postDummyResponse = new PostDummyResponse(new Dummy(someUuid, dummyName));
    Mockito.when(
        dummyService.postDummy(postDummyRequest.dummyName())
    ).thenReturn(
        postDummyResponse
    );

    assertEquals(
        postDummyResponse.getInsertedRecord().getName(),
        dummyController.postDummy(postDummyRequest).getInsertedRecord().getName()
    );
  }
}