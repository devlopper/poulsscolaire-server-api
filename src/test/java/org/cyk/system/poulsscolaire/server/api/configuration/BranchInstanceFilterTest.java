package org.cyk.system.poulsscolaire.server.api.configuration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import org.junit.jupiter.api.Test;

class BranchInstanceFilterTest {
  
  @Test
  void doInitialize() {
    BranchInstanceFilter filter = new BranchInstanceFilter(null);
    filter.doInitialize(new FilterDto());
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
  
  @Test
  void toDto() {
    BranchInstanceFilter filter = new BranchInstanceFilter();
    FilterDto dto = filter.toDto();
    assertNotNull(dto);
  }
}
