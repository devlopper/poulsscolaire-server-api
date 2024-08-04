package org.cyk.system.poulsscolaire.server.api.configuration;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.ArgumentMatchers.any;

import jakarta.ws.rs.core.Response;
import org.cyk.system.poulsscolaire.server.api.configuration.BranchService.BranchGetManyResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BranchClientTest {

  BranchService service;
  BranchClient client;

  @BeforeEach
  void listenBeforeEach() {
    service = Mockito.mock(BranchService.class);
    client = new BranchClient().service(service);
  }
  
  @Test
  void getMany() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(BranchGetManyResponseDto.class))
        .thenReturn(new BranchGetManyResponseDto());
    Mockito.when(service.getMany(any())).thenReturn(response);
    assertInstanceOf(BranchGetManyResponseDto.class, client.getMany(null, null, null, null, null));
  }

  @Test
  void getOne() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(BranchDto.class)).thenReturn(new BranchDto());
    Mockito.when(service.getOne(any())).thenReturn(response);
    assertInstanceOf(BranchDto.class, client.getOne(null, null, null, null));
  }

  @Test
  void getByIdentifier() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(BranchDto.class)).thenReturn(new BranchDto());
    Mockito.when(service.getByIdentifier(any())).thenReturn(response);
    assertInstanceOf(BranchDto.class, client.getByIdentifier(null, null, null, null));
  }
}
