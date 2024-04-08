package org.cyk.system.poulsscolaire.server.api.configuration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class AssignmentTypeFilterTest {
  
  @Test
  void toDto() {
    AssignmentTypeFilter filter = new AssignmentTypeFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}
