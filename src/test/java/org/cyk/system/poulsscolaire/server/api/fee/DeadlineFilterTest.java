package org.cyk.system.poulsscolaire.server.api.fee;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class DeadlineFilterTest {
  
  @Test
  void toDto() {
    DeadlineFilter filter = new DeadlineFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}
