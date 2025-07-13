package com.ibm.it.meledina.tommaso.sample.quarkus.application.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.ibm.it.meledina.tommaso.sample.quarkus.application.service.DummyService;
import com.ibm.it.meledina.tommaso.sample.quarkus.model.dto.web.Dummy;
import com.ibm.it.meledina.tommaso.sample.quarkus.model.dto.web.request.PostDummyRequest;
import com.ibm.it.meledina.tommaso.sample.quarkus.model.dto.web.response.GetDummyResponse;
import com.ibm.it.meledina.tommaso.sample.quarkus.model.dto.web.response.PostDummyResponse;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@DisplayName("The /dummy resource controller")
@QuarkusTest
class DummyResourceTest {

  @Inject DummyResource dummyResource;

  @InjectMock DummyService dummyService;

  @Test
  @DisplayName("when initialized, it should load correctly")
  void initialization_instanceIsNotNull() {
    assertNotNull(dummyResource);
  }

  @Test
  @DisplayName("when executing getDummy, it should relay the result of DummyService.getDummy")
  void getDummy() {
    String uuid = "abc-123";
    GetDummyResponse getDummyResponse = new GetDummyResponse(List.of(new Dummy(uuid, "abc")));

    Mockito.when(dummyService.getDummies()).thenReturn(getDummyResponse);

    assertEquals(getDummyResponse, dummyResource.getDummies());
  }

  @Test
  @DisplayName("when executing postDummy, it should relay the result of DummyService.postDummy")
  void postDummy() {
    PostDummyRequest postDummyRequest = new PostDummyRequest("some name");
    PostDummyResponse postDummyResponse = new PostDummyResponse(1);

    Mockito.when(dummyService.addDummy(postDummyRequest.dummyName())).thenReturn(postDummyResponse);

    assertEquals(postDummyResponse, dummyResource.postDummy(postDummyRequest));
  }
}
