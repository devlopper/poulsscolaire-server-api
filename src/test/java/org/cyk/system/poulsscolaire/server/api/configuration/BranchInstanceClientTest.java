package org.cyk.system.poulsscolaire.server.api.configuration;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.ArgumentMatchers.any;

import jakarta.ws.rs.core.Response;
import org.cyk.system.poulsscolaire.server.api.configuration.BranchInstanceService.BranchInstanceGetManyResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BranchInstanceClientTest {

  BranchInstanceService service;
  BranchInstanceClient client;

  @BeforeEach
  void listenBeforeEach() {
    service = Mockito.mock(BranchInstanceService.class);
    client = new BranchInstanceClient().service(service);
  }

  @Test
  void getMany() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(BranchInstanceGetManyResponseDto.class))
        .thenReturn(new BranchInstanceGetManyResponseDto());
    Mockito.when(service.getMany(any())).thenReturn(response);
    assertInstanceOf(BranchInstanceGetManyResponseDto.class,
        client.getMany(null, null, null, null, null));
  }

  @Test
  void getOne() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(BranchInstanceDto.class)).thenReturn(new BranchInstanceDto());
    Mockito.when(service.getOne(any())).thenReturn(response);
    assertInstanceOf(BranchInstanceDto.class, client.getOne(null, null, null, null));
  }

  @Test
  void getByIdentifier() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(BranchInstanceDto.class)).thenReturn(new BranchInstanceDto());
    Mockito.when(service.getByIdentifier(any())).thenReturn(response);
    assertInstanceOf(BranchInstanceDto.class, client.getByIdentifier(null, null, null, null));
  }
}
