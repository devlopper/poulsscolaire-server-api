package org.cyk.system.poulsscolaire.server.api.accounting;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import ci.gouv.dgbf.extension.server.service.api.response.CreateResponseDto;
import ci.gouv.dgbf.extension.server.service.api.response.IdentifiableResponseDto;
import ci.gouv.dgbf.extension.server.service.api.response.IdentifiablesResponseDto;
import jakarta.ws.rs.core.Response;
import org.cyk.system.poulsscolaire.server.api.accounting.FundingService.ByFilterWithReasonRequestDto;
import org.cyk.system.poulsscolaire.server.api.accounting.FundingService.FundingCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.accounting.FundingService.FundingGetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.accounting.FundingService.FundingReturnRequestDto;
import org.cyk.system.poulsscolaire.server.api.accounting.FundingService.FundingStatusUpdateResponseDto;
import org.cyk.system.poulsscolaire.server.api.accounting.FundingService.FundingUpdateAmountRequestDto;
import org.cyk.system.poulsscolaire.server.api.accounting.FundingService.FundingUpdateAmountResponseDto;
import org.cyk.system.poulsscolaire.server.api.accounting.FundingService.FundingUpdateRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FundingClientTest {

  FundingService service;
  FundingClient client;

  @BeforeEach
  void listenBeforeEach() {
    service = Mockito.mock(FundingService.class);
    client = new FundingClient().service(service);
  }

  @Test
  void create() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.CREATED.getStatusCode());
    Mockito.when(response.readEntity(CreateResponseDto.class)).thenReturn(new CreateResponseDto());
    Mockito.when(service.create(any())).thenReturn(response);
    assertInstanceOf(CreateResponseDto.class, client.create(new FundingCreateRequestDto()));
  }

  @Test
  void transmit() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(FundingStatusUpdateResponseDto.class))
        .thenReturn(new FundingStatusUpdateResponseDto());
    Mockito.when(service.transmit(any())).thenReturn(response);
    assertInstanceOf(FundingStatusUpdateResponseDto.class, client.transmit(null));
  }

  @Test
  void transmitByFilter() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(IdentifiablesResponseDto.class))
        .thenReturn(new IdentifiablesResponseDto());
    Mockito.when(service.transmitByFilter(any())).thenReturn(response);
    assertInstanceOf(IdentifiablesResponseDto.class, client.transmitByFilter(null));
  }

  @Test
  void accept() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(FundingStatusUpdateResponseDto.class))
        .thenReturn(new FundingStatusUpdateResponseDto());
    Mockito.when(service.accept(any())).thenReturn(response);
    assertInstanceOf(FundingStatusUpdateResponseDto.class, client.accept(null));
  }

  @Test
  void acceptByFilter() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(IdentifiablesResponseDto.class))
        .thenReturn(new IdentifiablesResponseDto());
    Mockito.when(service.acceptByFilter(any())).thenReturn(response);
    assertInstanceOf(IdentifiablesResponseDto.class, client.acceptByFilter(null));
  }

  @Test
  void approve() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    FundingStatusUpdateResponseDto budgetStatusUpdateResponse =
        new FundingStatusUpdateResponseDto();
    Mockito.when(response.readEntity(FundingStatusUpdateResponseDto.class))
        .thenReturn(budgetStatusUpdateResponse);
    Mockito.when(service.approve(any())).thenReturn(response);
    assertInstanceOf(FundingStatusUpdateResponseDto.class, client.approve(null));
  }

  @Test
  void approveByFilter() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(IdentifiablesResponseDto.class))
        .thenReturn(new IdentifiablesResponseDto());
    Mockito.when(service.approveByFilter(any())).thenReturn(response);
    assertInstanceOf(IdentifiablesResponseDto.class, client.approveByFilter(null));
  }

  @Test
  void returnBack() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(FundingStatusUpdateResponseDto.class))
        .thenReturn(new FundingStatusUpdateResponseDto());
    Mockito.when(service.returnBack(any())).thenReturn(response);
    assertInstanceOf(FundingStatusUpdateResponseDto.class,
        client.returnBack(new FundingReturnRequestDto()));
  }

  @Test
  void returnBackByFilter() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(IdentifiablesResponseDto.class))
        .thenReturn(new IdentifiablesResponseDto());
    Mockito.when(service.returnBackByFilter(any())).thenReturn(response);
    assertInstanceOf(IdentifiablesResponseDto.class,
        client.returnBackByFilter(new ByFilterWithReasonRequestDto()));
  }

  @Test
  void getMany() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(FundingGetManyResponseDto.class))
        .thenReturn(new FundingGetManyResponseDto());
    Mockito.when(service.getMany(any())).thenReturn(response);
    assertInstanceOf(FundingGetManyResponseDto.class, client.getMany(null, null, null, null, null));
  }

  @Test
  void getOne() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(FundingDto.class)).thenReturn(new FundingDto());
    Mockito.when(service.getOne(any())).thenReturn(response);
    assertInstanceOf(FundingDto.class, client.getOne(null, null, null, null));
  }

  @Test
  void getByIdentifier() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(FundingDto.class)).thenReturn(new FundingDto());
    Mockito.when(service.getByIdentifier(any())).thenReturn(response);
    assertInstanceOf(FundingDto.class, client.getByIdentifier(null, null, null, null));
  }

  @Test
  void update() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(IdentifiableResponseDto.class))
        .thenReturn(new IdentifiableResponseDto());
    Mockito.when(service.update(any())).thenReturn(response);
    assertInstanceOf(IdentifiableResponseDto.class, client.update(new FundingUpdateRequestDto()));
  }

  @Test
  void updateAmount() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(response.readEntity(FundingUpdateAmountResponseDto.class))
        .thenReturn(new FundingUpdateAmountResponseDto());
    Mockito.when(service.updateAmount(any())).thenReturn(response);
    assertInstanceOf(FundingUpdateAmountResponseDto.class,
        client.updateAmount(new FundingUpdateAmountRequestDto()));
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
    FundingStatusUpdateResponseDto budgetStatusUpdateResponse =
        new FundingStatusUpdateResponseDto();
    budgetStatusUpdateResponse.initialize(FundingStatus.CREATED, null, null);
    assertTrue(budgetStatusUpdateResponse.getTransmitable());
  }

  @Test
  void budget_copy() {
    FundingDto budget = new FundingDto();
    budget.copy(new FundingStatusUpdateResponseDto());
    assertNull(budget.getAcceptable());
  }
}
