package org.cyk.system.poulsscolaire.server.api.report;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;

import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ReportClientTest {

  ReportService service;
  ReportClient client;

  @BeforeEach
  void listenBeforeEach() {
    service = Mockito.mock(ReportService.class);
    client = new ReportClient().service(service);
  }
  
  @Test
  void getBytesByIdentifier() {
    Response response = Mockito.mock(Response.class);
    Mockito.when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
    Mockito.when(service.getBytesByIdentifier(any())).thenReturn(response);

    assertDoesNotThrow(() -> client.getBytesByIdentifier(null, null, null, null, null));
  }
}
