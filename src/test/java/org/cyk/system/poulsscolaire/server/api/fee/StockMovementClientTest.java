package org.cyk.system.poulsscolaire.server.api.fee;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.ArgumentMatchers.any;

import jakarta.ws.rs.core.Response;
import org.cyk.system.poulsscolaire.server.api.fee.StockMovementService.StockMovementCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.fee.StockMovementService.StockMovementCreateResponseDto;
import org.cyk.system.poulsscolaire.server.api.fee.StockMovementService.StockMovementDeleteResponseDto;
import org.cyk.system.poulsscolaire.server.api.fee.StockMovementService.StockMovementGetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.fee.StockMovementService.StockMovementUpdateRequestDto;
import org.cyk.system.poulsscolaire.server.api.fee.StockMovementService.StockMovementUpdateResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class StockMovementClientTest {

  StockMovementService service;
  StockMovementClient client;

  @BeforeEach
  void listenBeforeEach() {
    service = Mockito.mock(StockMovementService.class);
    client = new StockMovementClient().service(service);
  }

  @Test
  void create() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.CREATED.getStatusCode());
    Mockito.when(response.readEntity(StockMovementCreateResponseDto.class))
        .thenReturn(new StockMovementCreateResponseDto());
    Mockito.when(service.create(any())).thenReturn(response);
    assertInstanceOf(StockMovementCreateResponseDto.class,
        client.create(new StockMovementCreateRequestDto()));
  }

  @Test
  void getMany() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(StockMovementGetManyResponseDto.class))
        .thenReturn(new StockMovementGetManyResponseDto());
    Mockito.when(service.getMany(any())).thenReturn(response);
    assertInstanceOf(StockMovementGetManyResponseDto.class,
        client.getMany(null, null, null, null, null));
  }

  @Test
  void getOne() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(StockMovementDto.class)).thenReturn(new StockMovementDto());
    Mockito.when(service.getOne(any())).thenReturn(response);
    assertInstanceOf(StockMovementDto.class, client.getOne(null, null, null, null));
  }

  @Test
  void getByIdentifier() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(StockMovementDto.class)).thenReturn(new StockMovementDto());
    Mockito.when(service.getByIdentifier(any())).thenReturn(response);
    assertInstanceOf(StockMovementDto.class, client.getByIdentifier(null, null, null, null));
  }

  @Test
  void update() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(StockMovementUpdateResponseDto.class))
        .thenReturn(new StockMovementUpdateResponseDto());
    Mockito.when(service.update(any())).thenReturn(response);
    assertInstanceOf(StockMovementUpdateResponseDto.class,
        client.update(new StockMovementUpdateRequestDto()));
  }

  @Test
  void deleteByIdentifier() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(StockMovementDeleteResponseDto.class))
        .thenReturn(new StockMovementDeleteResponseDto());
    Mockito.when(service.delete(any())).thenReturn(response);
    assertInstanceOf(StockMovementDeleteResponseDto.class,
        client.deleteByIdentifier(null, null, null));
  }
}
