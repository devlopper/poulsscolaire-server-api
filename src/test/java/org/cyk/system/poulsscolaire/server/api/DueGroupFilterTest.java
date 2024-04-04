package org.cyk.system.poulsscolaire.server.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class DueGroupFilterTest {
  
  @Test
  void toDto() {
    DueGroupFilter filter = new DueGroupFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}
