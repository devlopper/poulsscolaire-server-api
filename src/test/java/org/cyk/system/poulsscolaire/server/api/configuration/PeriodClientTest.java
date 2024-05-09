package org.cyk.system.poulsscolaire.server.api.configuration;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.ArgumentMatchers.any;

import jakarta.ws.rs.core.Response;
import org.cyk.system.poulsscolaire.server.api.configuration.PeriodService.GetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.configuration.PeriodService.PeriodRepatriateResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PeriodClientTest {

  PeriodService service;
  PeriodClient client;

  @BeforeEach
  void listenBeforeEach() {
    service = Mockito.mock(PeriodService.class);
    client = new PeriodClient().service(service);
  }

  @Test
  void repatriate() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(PeriodRepatriateResponseDto.class))
        .thenReturn(new PeriodRepatriateResponseDto());
    Mockito.when(service.repatriate(any())).thenReturn(response);
    assertInstanceOf(PeriodRepatriateResponseDto.class, client.repatriate(null, null));
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
    Mockito.when(response.readEntity(PeriodDto.class)).thenReturn(new PeriodDto());
    Mockito.when(service.getOne(any())).thenReturn(response);
    assertInstanceOf(PeriodDto.class, client.getOne(null, null, null, null));
  }

  @Test
  void getByIdentifier() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(PeriodDto.class)).thenReturn(new PeriodDto());
    Mockito.when(service.getByIdentifier(any())).thenReturn(response);
    assertInstanceOf(PeriodDto.class, client.getByIdentifier(null, null, null, null));
  }
}
