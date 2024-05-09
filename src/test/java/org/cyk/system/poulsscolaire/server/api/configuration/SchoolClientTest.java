package org.cyk.system.poulsscolaire.server.api.configuration;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.ArgumentMatchers.any;

import jakarta.ws.rs.core.Response;
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolService.GetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolService.SchoolRepatriateResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SchoolClientTest {

  SchoolService service;
  SchoolClient client;

  @BeforeEach
  void listenBeforeEach() {
    service = Mockito.mock(SchoolService.class);
    client = new SchoolClient().service(service);
  }

  @Test
  void repatriate() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(SchoolRepatriateResponseDto.class))
        .thenReturn(new SchoolRepatriateResponseDto());
    Mockito.when(service.repatriate(any())).thenReturn(response);
    assertInstanceOf(SchoolRepatriateResponseDto.class, client.repatriate(null, null));
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
    Mockito.when(response.readEntity(SchoolDto.class)).thenReturn(new SchoolDto());
    Mockito.when(service.getOne(any())).thenReturn(response);
    assertInstanceOf(SchoolDto.class, client.getOne(null, null, null, null));
  }

  @Test
  void getByIdentifier() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(SchoolDto.class)).thenReturn(new SchoolDto());
    Mockito.when(service.getByIdentifier(any())).thenReturn(response);
    assertInstanceOf(SchoolDto.class, client.getByIdentifier(null, null, null, null));
  }
}
