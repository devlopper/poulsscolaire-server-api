package org.cyk.system.poulsscolaire.server.api.configuration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class UserFilterTest {
  
  @Test
  void doInitialize() {
    UserFilter filter = new UserFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
  
  @Test
  void toDto() {
    UserFilter filter = new UserFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}
