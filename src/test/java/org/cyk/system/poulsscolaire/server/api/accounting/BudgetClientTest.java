package org.cyk.system.poulsscolaire.server.api.accounting;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import ci.gouv.dgbf.extension.server.service.api.response.CreateResponseDto;
import ci.gouv.dgbf.extension.server.service.api.response.IdentifiableResponseDto;
import jakarta.ws.rs.core.Response;
import org.cyk.system.poulsscolaire.server.api.accounting.BudgetService.BudgetCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.accounting.BudgetService.BudgetGetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.accounting.BudgetService.BudgetReturnRequestDto;
import org.cyk.system.poulsscolaire.server.api.accounting.BudgetService.BudgetStatusUpdateResponseDto;
import org.cyk.system.poulsscolaire.server.api.accounting.BudgetService.BudgetUpdateRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BudgetClientTest {

  BudgetService service;
  BudgetClient client;

  @BeforeEach
  void listenBeforeEach() {
    service = Mockito.mock(BudgetService.class);
    client = new BudgetClient().service(service);
  }

  @Test
  void create() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.CREATED.getStatusCode());
    Mockito.when(response.readEntity(CreateResponseDto.class)).thenReturn(new CreateResponseDto());
    Mockito.when(service.create(any())).thenReturn(response);
    assertInstanceOf(CreateResponseDto.class, client.create(new BudgetCreateRequestDto()));
  }

  @Test
  void transmit() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(BudgetStatusUpdateResponseDto.class))
        .thenReturn(new BudgetStatusUpdateResponseDto());
    Mockito.when(service.transmit(any())).thenReturn(response);
    assertInstanceOf(BudgetStatusUpdateResponseDto.class, client.transmit(null));
  }

  @Test
  void accept() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(BudgetStatusUpdateResponseDto.class))
        .thenReturn(new BudgetStatusUpdateResponseDto());
    Mockito.when(service.accept(any())).thenReturn(response);
    assertInstanceOf(BudgetStatusUpdateResponseDto.class, client.accept(null));
  }

  @Test
  void approve() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    BudgetStatusUpdateResponseDto budgetStatusUpdateResponse =
        new BudgetStatusUpdateResponseDto();
    Mockito.when(response.readEntity(BudgetStatusUpdateResponseDto.class))
        .thenReturn(budgetStatusUpdateResponse);
    Mockito.when(service.approve(any())).thenReturn(response);
    assertInstanceOf(BudgetStatusUpdateResponseDto.class, client.approve(null));
  }

  @Test
  void returnBack() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(BudgetStatusUpdateResponseDto.class))
        .thenReturn(new BudgetStatusUpdateResponseDto());
    Mockito.when(service.returnBack(any())).thenReturn(response);
    assertInstanceOf(BudgetStatusUpdateResponseDto.class,
        client.returnBack(new BudgetReturnRequestDto()));
  }

  @Test
  void getMany() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(BudgetGetManyResponseDto.class))
        .thenReturn(new BudgetGetManyResponseDto());
    Mockito.when(service.getMany(any())).thenReturn(response);
    assertInstanceOf(BudgetGetManyResponseDto.class, client.getMany(null, null, null, null, null));
  }

  @Test
  void getOne() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(BudgetDto.class)).thenReturn(new BudgetDto());
    Mockito.when(service.getOne(any())).thenReturn(response);
    assertInstanceOf(BudgetDto.class, client.getOne(null, null, null, null));
  }

  @Test
  void getByIdentifier() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(BudgetDto.class)).thenReturn(new BudgetDto());
    Mockito.when(service.getByIdentifier(any())).thenReturn(response);
    assertInstanceOf(BudgetDto.class, client.getByIdentifier(null, null, null, null));
  }

  @Test
  void update() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(IdentifiableResponseDto.class))
        .thenReturn(new IdentifiableResponseDto());
    Mockito.when(service.update(any())).thenReturn(response);
    assertInstanceOf(IdentifiableResponseDto.class, client.update(new BudgetUpdateRequestDto()));
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
  void budgetStatusUpdateResponse_initialize() {
    BudgetStatusUpdateResponseDto budgetStatusUpdateResponse =
        new BudgetStatusUpdateResponseDto();
    budgetStatusUpdateResponse.initialize(BudgetStatus.CREATED, null, null);
    assertTrue(budgetStatusUpdateResponse.getTransmitable());
  }

  @Test
  void budget_copy() {
    BudgetDto budget = new BudgetDto();
    budget.copy(new BudgetStatusUpdateResponseDto());
    assertNull(budget.getAcceptable());
  }
}
