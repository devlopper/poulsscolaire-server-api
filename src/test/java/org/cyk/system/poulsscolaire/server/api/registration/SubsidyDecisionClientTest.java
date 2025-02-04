package org.cyk.system.poulsscolaire.server.api.registration;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.ArgumentMatchers.any;

import ci.gouv.dgbf.extension.server.service.api.response.CreateResponseDto;
import ci.gouv.dgbf.extension.server.service.api.response.IdentifiableResponseDto;
import jakarta.ws.rs.core.Response;
import org.cyk.system.poulsscolaire.server.api.registration.SubsidyDecisionService.SubsidyDecisionCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.registration.SubsidyDecisionService.SubsidyDecisionGetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.registration.SubsidyDecisionService.SubsidyDecisionUpdateRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SubsidyDecisionClientTest {

  SubsidyDecisionService service;
  SubsidyDecisionClient client;

  @BeforeEach
  void listenBeforeEach() {
    service = Mockito.mock(SubsidyDecisionService.class);
    client = new SubsidyDecisionClient().service(service);
  }

  @Test
  void create() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.CREATED.getStatusCode());
    Mockito.when(response.readEntity(CreateResponseDto.class)).thenReturn(new CreateResponseDto());
    Mockito.when(service.create(any())).thenReturn(response);
    assertInstanceOf(CreateResponseDto.class, client.create(new SubsidyDecisionCreateRequestDto()));
  }

  @Test
  void getMany() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(SubsidyDecisionGetManyResponseDto.class))
        .thenReturn(new SubsidyDecisionGetManyResponseDto());
    Mockito.when(service.getMany(any())).thenReturn(response);
    assertInstanceOf(SubsidyDecisionGetManyResponseDto.class,
        client.getMany(null, null, null, null, null));
  }

  @Test
  void getOne() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(SubsidyDecisionDto.class))
        .thenReturn(new SubsidyDecisionDto());
    Mockito.when(service.getOne(any())).thenReturn(response);
    assertInstanceOf(SubsidyDecisionDto.class, client.getOne(null, null, null, null));
  }

  @Test
  void getByIdentifier() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(SubsidyDecisionDto.class))
        .thenReturn(new SubsidyDecisionDto());
    Mockito.when(service.getByIdentifier(any())).thenReturn(response);
    assertInstanceOf(SubsidyDecisionDto.class, client.getByIdentifier(null, null, null, null));
  }

  @Test
  void update() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(IdentifiableResponseDto.class))
        .thenReturn(new IdentifiableResponseDto());
    Mockito.when(service.update(any())).thenReturn(response);
    assertInstanceOf(IdentifiableResponseDto.class,
        client.update(new SubsidyDecisionUpdateRequestDto()));
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
