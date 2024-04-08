package org.cyk.system.poulsscolaire.server.api.payment;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class PaymentModeFilterTest {
  
  @Test
  void toDto() {
    PaymentModeFilter filter = new PaymentModeFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}
