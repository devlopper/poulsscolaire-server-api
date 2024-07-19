package org.cyk.system.poulsscolaire.server.api.fee;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.ArgumentMatchers.any;

import ci.gouv.dgbf.extension.server.service.api.response.CreateResponseDto;
import ci.gouv.dgbf.extension.server.service.api.response.IdentifiableResponseDto;
import jakarta.ws.rs.core.Response;
import org.cyk.system.poulsscolaire.server.api.fee.AdjustedFeePaymentDeadlineService.AdjustedFeePaymentDeadlineCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.fee.AdjustedFeePaymentDeadlineService.AdjustedFeePaymentDeadlineUpdateRequestDto;
import org.cyk.system.poulsscolaire.server.api.fee.AdjustedFeePaymentDeadlineService.GetManyResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AdjustedFeePaymentDeadlineClientTest {

  AdjustedFeePaymentDeadlineService service;
  AdjustedFeePaymentDeadlineClient client;

  @BeforeEach
  void listenBeforeEach() {
    service = Mockito.mock(AdjustedFeePaymentDeadlineService.class);
    client = new AdjustedFeePaymentDeadlineClient().service(service);
  }

  @Test
  void create() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.CREATED.getStatusCode());
    Mockito.when(response.readEntity(CreateResponseDto.class)).thenReturn(new CreateResponseDto());
    Mockito.when(service.create(any())).thenReturn(response);
    assertInstanceOf(CreateResponseDto.class,
        client.create(new AdjustedFeePaymentDeadlineCreateRequestDto()));
  }

  @Test
  void getMany() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(GetManyResponseDto.class))
        .thenReturn(new GetManyResponseDto());
    Mockito.when(service.getMany(any())).thenReturn(response);
    assertInstanceOf(GetManyResponseDto.class, client.getMany(null, null, null, null, null));
  }

  @Test
  void getOne() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(AdjustedFeePaymentDeadlineDto.class))
        .thenReturn(new AdjustedFeePaymentDeadlineDto());
    Mockito.when(service.getOne(any())).thenReturn(response);
    assertInstanceOf(AdjustedFeePaymentDeadlineDto.class, client.getOne(null, null, null, null));
  }

  @Test
  void getByIdentifier() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(AdjustedFeePaymentDeadlineDto.class))
        .thenReturn(new AdjustedFeePaymentDeadlineDto());
    Mockito.when(service.getByIdentifier(any())).thenReturn(response);
    assertInstanceOf(AdjustedFeePaymentDeadlineDto.class,
        client.getByIdentifier(null, null, null, null));
  }

  @Test
  void update() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(IdentifiableResponseDto.class))
        .thenReturn(new IdentifiableResponseDto());
    Mockito.when(service.update(any())).thenReturn(response);
    assertInstanceOf(IdentifiableResponseDto.class,
        client.update(new AdjustedFeePaymentDeadlineUpdateRequestDto()));
  }

  @Test
  void deleteByIdentifier() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(IdentifiableResponseDto.class))
        .thenReturn(new IdentifiableResponseDto());
    Mockito.when(service.delete(any())).thenReturn(response);
    assertInstanceOf(IdentifiableResponseDto.class, client.deleteByIdentifier(null, null, null));
  }
}
