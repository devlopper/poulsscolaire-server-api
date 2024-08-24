package org.cyk.system.poulsscolaire.server.api.registration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class IdentityFilterTest {
  
  @Test
  void doInitialize() {
    IdentityFilter filter = new IdentityFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
  
  @Test
  void toDto() {
    IdentityFilter filter = new IdentityFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}
