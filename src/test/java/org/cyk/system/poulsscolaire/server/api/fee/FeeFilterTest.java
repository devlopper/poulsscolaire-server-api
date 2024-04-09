package org.cyk.system.poulsscolaire.server.api.fee;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class FeeFilterTest {
  
  @Test
  void toDto() {
    FeeFilter filter = new FeeFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}
