package org.cyk.system.poulsscolaire.server.api.configuration;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.ArgumentMatchers.any;

import jakarta.ws.rs.core.Response;
import org.cyk.system.poulsscolaire.server.api.configuration.UserService.UserGetManyResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UserClientTest {

  UserService service;
  UserClient client;

  @BeforeEach
  void listenBeforeEach() {
    service = Mockito.mock(UserService.class);
    client = new UserClient().service(service);
  }
  
  @Test
  void getMany() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(UserGetManyResponseDto.class))
        .thenReturn(new UserGetManyResponseDto());
    Mockito.when(service.getMany(any())).thenReturn(response);
    assertInstanceOf(UserGetManyResponseDto.class, client.getMany(null, null, null, null, null));
  }

  @Test
  void getOne() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(UserDto.class)).thenReturn(new UserDto());
    Mockito.when(service.getOne(any())).thenReturn(response);
    assertInstanceOf(UserDto.class, client.getOne(null, null, null, null));
  }

  @Test
  void getByIdentifier() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(UserDto.class)).thenReturn(new UserDto());
    Mockito.when(service.getByIdentifier(any())).thenReturn(response);
    assertInstanceOf(UserDto.class, client.getByIdentifier(null, null, null, null));
  }
}
