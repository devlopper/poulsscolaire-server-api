package org.cyk.system.poulsscolaire.server.api.configuration;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.ArgumentMatchers.any;

import jakarta.ws.rs.core.Response;
import org.cyk.system.poulsscolaire.server.api.configuration.PeriodService.PeriodGetManyResponseDto;
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
  void getMany() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(PeriodGetManyResponseDto.class))
        .thenReturn(new PeriodGetManyResponseDto());
    Mockito.when(service.getMany(any())).thenReturn(response);
    assertInstanceOf(PeriodGetManyResponseDto.class, client.getMany(null, null, null, null, null));
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
