package org.cyk.system.poulsscolaire.server.api.configuration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class SchoolConfigurationFilterTest {
  
  @Test
  void doInitialize() {
    SchoolConfigurationFilter filter = new SchoolConfigurationFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
  
  @Test
  void toDto() {
    SchoolConfigurationFilter filter = new SchoolConfigurationFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}
