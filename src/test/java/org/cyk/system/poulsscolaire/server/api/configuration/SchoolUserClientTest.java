package org.cyk.system.poulsscolaire.server.api.configuration;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.ArgumentMatchers.any;

import jakarta.ws.rs.core.Response;
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolUserService.GetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolUserService.SchoolUserRepatriateResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SchoolUserClientTest {

  SchoolUserService service;
  SchoolUserClient client;

  @BeforeEach
  void listenBeforeEach() {
    service = Mockito.mock(SchoolUserService.class);
    client = new SchoolUserClient().service(service);
  }

  @Test
  void repatriate() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(SchoolUserRepatriateResponseDto.class))
        .thenReturn(new SchoolUserRepatriateResponseDto());
    Mockito.when(service.repatriate(any())).thenReturn(response);
    assertInstanceOf(SchoolUserRepatriateResponseDto.class, client.repatriate(null, null));
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
    Mockito.when(response.readEntity(SchoolUserDto.class)).thenReturn(new SchoolUserDto());
    Mockito.when(service.getOne(any())).thenReturn(response);
    assertInstanceOf(SchoolUserDto.class, client.getOne(null, null, null, null));
  }

  @Test
  void getByIdentifier() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(SchoolUserDto.class)).thenReturn(new SchoolUserDto());
    Mockito.when(service.getByIdentifier(any())).thenReturn(response);
    assertInstanceOf(SchoolUserDto.class, client.getByIdentifier(null, null, null, null));
  }
}
