package org.cyk.system.poulsscolaire.server.api.report;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class ReportServiceTest {

  @Test
  void instantiateParameterDto() {
    assertNotNull(new ReportService.ParameterDto());
  }
    
  @Test
  void instantiateGetBytesByIdentifierRequestDto() {
    assertNotNull(new ReportService.GetBytesByIdentifierRequestDto());
  }
}
