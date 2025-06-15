package org.cyk.system.poulsscolaire.server.api.fee;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import ci.gouv.dgbf.extension.server.service.api.response.CreateResponseDto;
import ci.gouv.dgbf.extension.server.service.api.response.IdentifiableResponseDto;
import jakarta.ws.rs.core.Response;
import org.cyk.system.poulsscolaire.server.api.fee.StockDistributionRegistrationService.StockDistributionRegistrationCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.fee.StockDistributionRegistrationService.StockDistributionRegistrationGetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.fee.StockDistributionRegistrationService.StockDistributionRegistrationUpdateRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;

class StockDistributionRegistrationTest {

  StockDistributionRegistrationService service;
  StockDistributionRegistrationClient client;
  StockDistributionRegistrationRequestMapper mapper =
      Mappers.getMapper(StockDistributionRegistrationRequestMapper.class);

  @BeforeEach
  void listenBeforeEach() {
    service = Mockito.mock(StockDistributionRegistrationService.class);
    client = new StockDistributionRegistrationClient().service(service);
  }

  @Test
  void create() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.CREATED.getStatusCode());
    Mockito.when(response.readEntity(CreateResponseDto.class)).thenReturn(new CreateResponseDto());
    Mockito.when(service.create(any())).thenReturn(response);
    assertInstanceOf(CreateResponseDto.class,
        client.create(new StockDistributionRegistrationCreateRequestDto()));
  }

  @Test
  void getMany() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(StockDistributionRegistrationGetManyResponseDto.class))
        .thenReturn(new StockDistributionRegistrationGetManyResponseDto());
    Mockito.when(service.getMany(any())).thenReturn(response);
    assertInstanceOf(StockDistributionRegistrationGetManyResponseDto.class,
        client.getMany(null, null, null, null, null));
  }

  @Test
  void getOne() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(StockDistributionRegistrationDto.class))
        .thenReturn(new StockDistributionRegistrationDto());
    Mockito.when(service.getOne(any())).thenReturn(response);
    assertInstanceOf(StockDistributionRegistrationDto.class, client.getOne(null, null, null, null));
  }

  @Test
  void getByIdentifier() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(StockDistributionRegistrationDto.class))
        .thenReturn(new StockDistributionRegistrationDto());
    Mockito.when(service.getByIdentifier(any())).thenReturn(response);
    assertInstanceOf(StockDistributionRegistrationDto.class,
        client.getByIdentifier(null, null, null, null));
  }

  @Test
  void update() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(IdentifiableResponseDto.class))
        .thenReturn(new IdentifiableResponseDto());
    Mockito.when(service.update(any())).thenReturn(response);
    assertInstanceOf(IdentifiableResponseDto.class,
        client.update(new StockDistributionRegistrationUpdateRequestDto()));
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

  @Test
  void filter_doInitialize() {
    StockDistributionRegistrationFilter filter = new StockDistributionRegistrationFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }

  @Test
  void filter_toDto() {
    StockDistributionRegistrationFilter filter = new StockDistributionRegistrationFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }

  @Test
  void mapCreation_whenNull() {
    assertNull(mapper.mapCreate(null));
  }

  @Test
  void mapCreation_whenPreRegistrationAmountNull() {
    assertNotNull(mapper.mapCreate(new StockDistributionRegistrationDto()));
  }

  @Test
  void mapUpdate_whenNull() {
    assertNull(mapper.mapUpdate(null));
  }

  @Test
  void mapUpdate_whenPreRegistrationAmountNull() {
    assertNotNull(mapper.mapUpdate(new StockDistributionRegistrationDto()));
  }
}
