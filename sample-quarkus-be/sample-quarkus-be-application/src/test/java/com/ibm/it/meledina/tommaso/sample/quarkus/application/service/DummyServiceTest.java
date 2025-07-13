package com.ibm.it.meledina.tommaso.sample.quarkus.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.ibm.it.meledina.tommaso.sample.quarkus.application.repository.DummyRepository;
import com.ibm.it.meledina.tommaso.sample.quarkus.model.dto.web.Dummy;
import com.ibm.it.meledina.tommaso.sample.quarkus.model.dto.web.response.GetDummyResponse;
import com.ibm.it.meledina.tommaso.sample.quarkus.model.dto.web.response.PostDummyResponse;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@DisplayName("The /dummy resource service")
@QuarkusTest
class DummyServiceTest {

  @Inject DummyService dummyService;

  @InjectMock DummyRepository dummyRepository;

  @Test
  @DisplayName("when initialized, it should load correctly")
  void initialization_instanceIsNotNull() {
    assertNotNull(dummyService);
  }

  @Test
  @DisplayName("when executing getDummy, it should relay the result of DummyRepository.getDummies")
  void getDummy() {
    String dummyTextProperty = "abc";
    String uuid = "abc-123";
    com.ibm.it.meledina.tommaso.sample.quarkus.model.entity.Dummy dummyEntity =
        new com.ibm.it.meledina.tommaso.sample.quarkus.model.entity.Dummy(0L, uuid, dummyTextProperty);
    Dummy expectedDummy = new Dummy(uuid, dummyTextProperty);
    GetDummyResponse expectedResponse = new GetDummyResponse(List.of(expectedDummy));

    Mockito.when(dummyRepository.getDummies()).thenReturn(List.of(dummyEntity));

    assertEquals(expectedResponse, dummyService.getDummies());
  }

  @Test
  @DisplayName(
      "when successfully executing postDummy, it should relay the result of DummyRepository.createDummy")
  void postDummy_successful() {
    String dummyName = "abc";
    boolean executionOutcome = true;
    int numberOfInsertedRecords = 1;
    PostDummyResponse expectedResponse = new PostDummyResponse(numberOfInsertedRecords);

    Mockito.when(dummyRepository.addDummy(dummyName)).thenReturn(executionOutcome);

    assertEquals(expectedResponse, dummyService.addDummy(dummyName));
  }

  @Test
  @DisplayName(
      "when unsuccessfully executing postDummy, it should relay the result of DummyRepository.createDummy")
  void postDummy_unsuccessful() {
    String dummyName = "abc";
    boolean executionOutcome = false;
    int numberOfInsertedRecords = 0;
    PostDummyResponse expectedResponse = new PostDummyResponse(numberOfInsertedRecords);

    Mockito.when(dummyRepository.addDummy(dummyName)).thenReturn(executionOutcome);

    assertEquals(expectedResponse, dummyService.addDummy(dummyName));
  }
}
