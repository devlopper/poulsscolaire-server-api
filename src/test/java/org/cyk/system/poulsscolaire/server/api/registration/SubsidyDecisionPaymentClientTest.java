package org.cyk.system.poulsscolaire.server.api.registration;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.ArgumentMatchers.any;

import ci.gouv.dgbf.extension.server.service.api.response.CreateResponseDto;
import ci.gouv.dgbf.extension.server.service.api.response.IdentifiableResponseDto;
import jakarta.ws.rs.core.Response;
import org.cyk.system.poulsscolaire.server.api.registration.SubsidyDecisionPaymentService.SubsidyDecisionPaymentCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.registration.SubsidyDecisionPaymentService.SubsidyDecisionPaymentGetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.registration.SubsidyDecisionPaymentService.SubsidyDecisionPaymentUpdateRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SubsidyDecisionPaymentClientTest {

  SubsidyDecisionPaymentService service;
  SubsidyDecisionPaymentClient client;

  @BeforeEach
  void listenBeforeEach() {
    service = Mockito.mock(SubsidyDecisionPaymentService.class);
    client = new SubsidyDecisionPaymentClient().service(service);
  }

  @Test
  void create() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.CREATED.getStatusCode());
    Mockito.when(response.readEntity(CreateResponseDto.class)).thenReturn(new CreateResponseDto());
    Mockito.when(service.create(any())).thenReturn(response);
    assertInstanceOf(CreateResponseDto.class,
        client.create(new SubsidyDecisionPaymentCreateRequestDto()));
  }

  @Test
  void getMany() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(SubsidyDecisionPaymentGetManyResponseDto.class))
        .thenReturn(new SubsidyDecisionPaymentGetManyResponseDto());
    Mockito.when(service.getMany(any())).thenReturn(response);
    assertInstanceOf(SubsidyDecisionPaymentGetManyResponseDto.class,
        client.getMany(null, null, null, null, null));
  }

  @Test
  void getOne() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(SubsidyDecisionPaymentDto.class))
        .thenReturn(new SubsidyDecisionPaymentDto());
    Mockito.when(service.getOne(any())).thenReturn(response);
    assertInstanceOf(SubsidyDecisionPaymentDto.class, client.getOne(null, null, null, null));
  }

  @Test
  void getByIdentifier() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(SubsidyDecisionPaymentDto.class))
        .thenReturn(new SubsidyDecisionPaymentDto());
    Mockito.when(service.getByIdentifier(any())).thenReturn(response);
    assertInstanceOf(SubsidyDecisionPaymentDto.class,
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
        client.update(new SubsidyDecisionPaymentUpdateRequestDto()));
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
