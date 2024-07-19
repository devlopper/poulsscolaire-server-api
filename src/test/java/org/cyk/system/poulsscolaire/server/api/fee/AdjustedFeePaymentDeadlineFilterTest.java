package org.cyk.system.poulsscolaire.server.api.fee;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class AdjustedFeePaymentDeadlineFilterTest {

  @Test
  void doInitialize() {
    AdjustedFeePaymentDeadlineFilter filter = new AdjustedFeePaymentDeadlineFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }

  @Test
  void toDto() {
    AdjustedFeePaymentDeadlineFilter filter = new AdjustedFeePaymentDeadlineFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}
