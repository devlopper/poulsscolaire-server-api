package org.cyk.system.poulsscolaire.server.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class RegistrationFilterTest {
  
  @Test
  void toDto() {
    RegistrationFilter filter = new RegistrationFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}
