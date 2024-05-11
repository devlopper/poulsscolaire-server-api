package org.cyk.system.poulsscolaire.server.api.configuration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class SchoolingFilterTest {
  
  @Test
  void doInitialize() {
    SchoolingFilter filter = new SchoolingFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
  
  @Test
  void toDto() {
    SchoolingFilter filter = new SchoolingFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}
