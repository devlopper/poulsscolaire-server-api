package org.cyk.system.poulsscolaire.server.api.configuration;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.ArgumentMatchers.any;

import jakarta.ws.rs.core.Response;
import org.cyk.system.poulsscolaire.server.api.configuration.DepartmentService.DepartmentGetManyResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DepartmentClientTest {

  DepartmentService service;
  DepartmentClient client;

  @BeforeEach
  void listenBeforeEach() {
    service = Mockito.mock(DepartmentService.class);
    client = new DepartmentClient().service(service);
  }

  @Test
  void getMany() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(DepartmentGetManyResponseDto.class))
        .thenReturn(new DepartmentGetManyResponseDto());
    Mockito.when(service.getMany(any())).thenReturn(response);
    assertInstanceOf(DepartmentGetManyResponseDto.class,
        client.getMany(null, null, null, null, null));
  }

  @Test
  void getOne() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(DepartmentDto.class))
        .thenReturn(new DepartmentDto());
    Mockito.when(service.getOne(any())).thenReturn(response);
    assertInstanceOf(DepartmentDto.class, client.getOne(null, null, null, null));
  }

  @Test
  void getByIdentifier() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(DepartmentDto.class))
        .thenReturn(new DepartmentDto());
    Mockito.when(service.getByIdentifier(any())).thenReturn(response);
    assertInstanceOf(DepartmentDto.class, client.getByIdentifier(null, null, null, null));
  }
}
