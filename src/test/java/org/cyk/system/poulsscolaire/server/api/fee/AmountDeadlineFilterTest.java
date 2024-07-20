package org.cyk.system.poulsscolaire.server.api.fee;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class AmountDeadlineFilterTest {

  @Test
  void doInitialize() {
    AmountDeadlineFilter filter = new AmountDeadlineFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }

  @Test
  void toDto() {
    AmountDeadlineFilter filter = new AmountDeadlineFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}
