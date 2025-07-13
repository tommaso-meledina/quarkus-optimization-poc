package com.ibm.it.meledina.tommaso.sample.quarkus.application.provider;

import com.ibm.it.meledina.tommaso.sample.quarkus.model.dto.web.response.BaseResponse;
import jakarta.validation.ValidationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ValidationExceptionProvider implements ExceptionMapper<ValidationException> {

  @Override
  public Response toResponse(ValidationException ve) {
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(new BaseResponse(ve.getMessage()))
        .type(MediaType.APPLICATION_JSON)
        .build();
  }
}
