package org.cyk.system.poulsscolaire.server.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class DeadlineGroupFilterTest {
  
  @Test
  void toDto() {
    DeadlineGroupFilter filter = new DeadlineGroupFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}
