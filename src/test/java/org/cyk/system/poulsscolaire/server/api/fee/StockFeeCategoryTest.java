package org.cyk.system.poulsscolaire.server.api.fee;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import ci.gouv.dgbf.extension.server.service.api.response.CreateResponseDto;
import ci.gouv.dgbf.extension.server.service.api.response.IdentifiableResponseDto;
import jakarta.ws.rs.core.Response;
import org.cyk.system.poulsscolaire.server.api.fee.StockFeeCategoryService.StockFeeCategoryCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.fee.StockFeeCategoryService.StockFeeCategoryGetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.fee.StockFeeCategoryService.StockFeeCategoryUpdateRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;

class StockFeeCategoryTest {

  StockFeeCategoryService service;
  StockFeeCategoryClient client;
  StockFeeCategoryRequestMapper mapper = Mappers.getMapper(StockFeeCategoryRequestMapper.class);

  @BeforeEach
  void listenBeforeEach() {
    service = Mockito.mock(StockFeeCategoryService.class);
    client = new StockFeeCategoryClient().service(service);
  }

  @Test
  void create() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.CREATED.getStatusCode());
    Mockito.when(response.readEntity(CreateResponseDto.class)).thenReturn(new CreateResponseDto());
    Mockito.when(service.create(any())).thenReturn(response);
    assertInstanceOf(CreateResponseDto.class,
        client.create(new StockFeeCategoryCreateRequestDto()));
  }

  @Test
  void getMany() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(StockFeeCategoryGetManyResponseDto.class))
        .thenReturn(new StockFeeCategoryGetManyResponseDto());
    Mockito.when(service.getMany(any())).thenReturn(response);
    assertInstanceOf(StockFeeCategoryGetManyResponseDto.class,
        client.getMany(null, null, null, null, null));
  }

  @Test
  void getOne() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(StockFeeCategoryDto.class))
        .thenReturn(new StockFeeCategoryDto());
    Mockito.when(service.getOne(any())).thenReturn(response);
    assertInstanceOf(StockFeeCategoryDto.class, client.getOne(null, null, null, null));
  }

  @Test
  void getByIdentifier() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(StockFeeCategoryDto.class))
        .thenReturn(new StockFeeCategoryDto());
    Mockito.when(service.getByIdentifier(any())).thenReturn(response);
    assertInstanceOf(StockFeeCategoryDto.class, client.getByIdentifier(null, null, null, null));
  }

  @Test
  void update() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(IdentifiableResponseDto.class))
        .thenReturn(new IdentifiableResponseDto());
    Mockito.when(service.update(any())).thenReturn(response);
    assertInstanceOf(IdentifiableResponseDto.class,
        client.update(new StockFeeCategoryUpdateRequestDto()));
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
    StockFeeCategoryFilter filter = new StockFeeCategoryFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }

  @Test
  void filter_toDto() {
    StockFeeCategoryFilter filter = new StockFeeCategoryFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }

  @Test
  void mapper_mapCreation_whenNull() {
    assertNull(mapper.mapCreate(null));
  }

  @Test
  void mapper_mapCreation_whenNotNull() {
    assertNotNull(mapper.mapCreate(new StockFeeCategoryDto()));
  }

  @Test
  void mapper_mapUpdate_whenNull() {
    assertNull(mapper.mapUpdate(null));
  }

  @Test
  void mapper_mapUpdate_whenNotNull() {
    assertNotNull(mapper.mapUpdate(new StockFeeCategoryDto()));
  }
}
