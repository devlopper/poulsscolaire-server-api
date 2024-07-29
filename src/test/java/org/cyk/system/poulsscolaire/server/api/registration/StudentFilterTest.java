package org.cyk.system.poulsscolaire.server.api.registration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class StudentFilterTest {
  
  @Test
  void doInitialize() {
    StudentFilter filter = new StudentFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
  
  @Test
  void toDto() {
    StudentFilter filter = new StudentFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}
