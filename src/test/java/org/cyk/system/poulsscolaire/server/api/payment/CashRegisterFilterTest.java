package org.cyk.system.poulsscolaire.server.api.payment;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class CashRegisterFilterTest {
  
  @Test
  void toDto() {
    CashRegisterFilter filter = new CashRegisterFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}
