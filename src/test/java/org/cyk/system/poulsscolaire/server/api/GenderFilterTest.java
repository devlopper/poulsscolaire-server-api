package org.cyk.system.poulsscolaire.server.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class GenderFilterTest {
  
  @Test
  void toDto() {
    GenderFilter filter = new GenderFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}
