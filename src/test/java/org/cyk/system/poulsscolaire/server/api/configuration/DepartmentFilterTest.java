package org.cyk.system.poulsscolaire.server.api.configuration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class DepartmentFilterTest {
  
  @Test
  void doInitialize() {
    DepartmentFilter filter = new DepartmentFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
  
  @Test
  void toDto() {
    DepartmentFilter filter = new DepartmentFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}
