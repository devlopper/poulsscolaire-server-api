package org.cyk.system.poulsscolaire.server.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class SeniorityFilterTest {
  
  @Test
  void toDto() {
    SeniorityFilter filter = new SeniorityFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}
