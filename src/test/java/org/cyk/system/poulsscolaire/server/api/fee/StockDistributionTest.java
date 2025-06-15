package org.cyk.system.poulsscolaire.server.api.fee;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import ci.gouv.dgbf.extension.server.service.api.response.CreateResponseDto;
import ci.gouv.dgbf.extension.server.service.api.response.IdentifiableResponseDto;
import jakarta.ws.rs.core.Response;
import org.cyk.system.poulsscolaire.server.api.fee.StockDistributionService.StockDistributionCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.fee.StockDistributionService.StockDistributionGetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.fee.StockDistributionService.StockDistributionUpdateRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;

class StockDistributionTest {

  StockDistributionService service;
  StockDistributionClient client;
  StockDistributionRequestMapper mapper = Mappers.getMapper(StockDistributionRequestMapper.class);

  @BeforeEach
  void listenBeforeEach() {
    service = Mockito.mock(StockDistributionService.class);
    client = new StockDistributionClient().service(service);
  }

  @Test
  void create() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.CREATED.getStatusCode());
    Mockito.when(response.readEntity(CreateResponseDto.class)).thenReturn(new CreateResponseDto());
    Mockito.when(service.create(any())).thenReturn(response);
    assertInstanceOf(CreateResponseDto.class,
        client.create(new StockDistributionCreateRequestDto()));
  }

  @Test
  void getMany() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(StockDistributionGetManyResponseDto.class))
        .thenReturn(new StockDistributionGetManyResponseDto());
    Mockito.when(service.getMany(any())).thenReturn(response);
    assertInstanceOf(StockDistributionGetManyResponseDto.class,
        client.getMany(null, null, null, null, null));
  }

  @Test
  void getOne() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(StockDistributionDto.class))
        .thenReturn(new StockDistributionDto());
    Mockito.when(service.getOne(any())).thenReturn(response);
    assertInstanceOf(StockDistributionDto.class, client.getOne(null, null, null, null));
  }

  @Test
  void getByIdentifier() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(StockDistributionDto.class))
        .thenReturn(new StockDistributionDto());
    Mockito.when(service.getByIdentifier(any())).thenReturn(response);
    assertInstanceOf(StockDistributionDto.class, client.getByIdentifier(null, null, null, null));
  }

  @Test
  void update() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(IdentifiableResponseDto.class))
        .thenReturn(new IdentifiableResponseDto());
    Mockito.when(service.update(any())).thenReturn(response);
    assertInstanceOf(IdentifiableResponseDto.class,
        client.update(new StockDistributionUpdateRequestDto()));
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
    StockDistributionFilter filter = new StockDistributionFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }

  @Test
  void filter_toDto() {
    StockDistributionFilter filter = new StockDistributionFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
  
  @Test
  void mapCreation_whenNull() {
    assertNull(mapper.mapCreate(null));
  }

  @Test
  void mapCreation_whenPreRegistrationAmountNull() {
    assertNotNull(mapper.mapCreate(new StockDistributionDto()));
  }

  @Test
  void mapUpdate_whenNull() {
    assertNull(mapper.mapUpdate(null));
  }

  @Test
  void mapUpdate_whenPreRegistrationAmountNull() {
    assertNotNull(mapper.mapUpdate(new StockDistributionDto()));
  }
}
