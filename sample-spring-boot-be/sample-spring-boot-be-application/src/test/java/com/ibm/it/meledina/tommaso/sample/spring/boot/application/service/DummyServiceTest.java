package com.ibm.it.meledina.tommaso.sample.spring.boot.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.ibm.it.meledina.tommaso.sample.spring.boot.application.repository.DummyRepository;
import com.ibm.it.meledina.tommaso.sample.spring.boot.model.dto.web.response.PostDummyResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@DisplayName("The /dummy resource service")
@SpringBootTest(classes = DummyService.class)
class DummyServiceTest {

  @Autowired
  private DummyService dummyService;

  @MockitoBean
  private DummyRepository dummyRepository;

  @Test
  @DisplayName("when initialized, it should load correctly")
  void initialization_instanceIsNotNull() {
    assertNotNull(dummyService);
  }

//  @Test
//  @DisplayName("when executing getDummy, it should relay the result of DummyRepository.getDummy")
//  void getDummy() {
//    final String dummyTextProperty = "abc";
//    final int dummyNumberProperty = 123;
//    final GetDummiesQueryRow getDummiesQueryRow =
//        new GetDummiesQueryRow(dummyTextProperty, dummyNumberProperty);
//    final GetDummyResponse getDummyResponse =
//        new GetDummyResponse(List.of(new Dummy(dummyTextProperty, dummyNumberProperty)));
//    Mockito.when(
//        dummyRepository.getDummies()
//    ).thenReturn(List.of(getDummiesQueryRow));
//    assertEquals(
//        getDummyResponse,
//        dummyService.getDummy()
//    );
//  }

//  @Test
//  @DisplayName("when executing postDummy, it should relay the result of DummyRepository.createDummy")
//  void postDummy() {
//    final String dummyName = "abc";
//    final int numberOfInsertedRecords = 1;
//    final PostDummyResponse postDummyResponse =
//        new PostDummyResponse(numberOfInsertedRecords);
//    Mockito.when(
//        dummyRepository.createDummy(dummyName)
//    ).thenReturn(numberOfInsertedRecords);
//    assertEquals(
//        postDummyResponse,
//        dummyService.postDummy(dummyName)
//    );
//  }
}