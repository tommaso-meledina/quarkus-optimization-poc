package com.ibm.it.meledina.tommaso.sample.quarkus.application.resource;

import com.ibm.it.meledina.tommaso.sample.quarkus.application.service.DummyService;
import com.ibm.it.meledina.tommaso.sample.quarkus.model.dto.web.request.PostDummyRequest;
import com.ibm.it.meledina.tommaso.sample.quarkus.model.dto.web.request.PutDummyRequest;
import com.ibm.it.meledina.tommaso.sample.quarkus.model.dto.web.response.GetDummyResponse;
import com.ibm.it.meledina.tommaso.sample.quarkus.model.dto.web.response.PostDummyResponse;
import com.ibm.it.meledina.tommaso.sample.quarkus.model.dto.web.response.PutDummyResponse;
import io.micrometer.core.annotation.Counted;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;

@Path("/dummies")
@RequiredArgsConstructor
public class DummyResource {

  private final DummyService dummyService;

  @Counted(
      value = "count_getDummy_invocations_total",
      description = "counts how many times operation GET /dummies is invoked")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public GetDummyResponse getDummies() {
    return dummyService.getDummies();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public PostDummyResponse postDummy(PostDummyRequest postDummyRequest) {
    return dummyService.addDummy(postDummyRequest.dummyName());
  }

  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  public PutDummyResponse putDummy(@Valid PutDummyRequest request) {
    return dummyService.updateDummy(request.dummy());
  }
}
